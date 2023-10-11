package com.example.book_store.service.impl;

import com.example.book_store.model.dto.request.AccountRequestDto;
import com.example.book_store.model.dto.request.SignUpRequestDto;
import com.example.book_store.model.entity.Account;
import com.example.book_store.model.entity.Role;
import com.example.book_store.model.entity.User;
import com.example.book_store.model.enums.ERole;
import com.example.book_store.repository.AccountRepository;
import com.example.book_store.service.AccountService;
import com.example.book_store.service.RoleService;
import com.example.book_store.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final RoleService roleService;

    @Override
    public Account add(SignUpRequestDto signUpRequestDto) {
        Role role = roleService.findByRoleName(ERole.USER);
        if (!accountRepository.existsByUsername(signUpRequestDto.getUsername())) {
            Account account = Account.builder()
                    .username(signUpRequestDto.getUsername())
                    .password(signUpRequestDto.getPassword())
                    .roles(Set.of(role))
                    .build();
            return accountRepository.save(account);
        }
        throw new RuntimeException("Account not saved");
    }

    @Override
    public void addRole(String id, String roleName) {
        ERole eRole = ERole.USER;
        if (roleName.equalsIgnoreCase("ADMIN"))
            eRole = ERole.ADMIN;
        Role role = roleService.findByRoleName(eRole);
        if (!accountRepository.existsByRoles(role)){
            Account account = accountRepository.findById(id).get();
            account.getRoles().add(role);
            accountRepository.save(account);
        }
    }

    @Override
    public void deleteRole(String id, String roleName) {
        ERole eRole = ERole.ADMIN;
        if (roleName.equalsIgnoreCase("USER"))
            eRole = ERole.USER;
        Role role = roleService.findByRoleName(eRole);
        if (accountRepository.existsByRoles(role)){
            Account account = accountRepository.findById(id).get();
            account.getRoles().remove(role);
            accountRepository.save(account);
        }
    }

    @Override
    public Account update(String id, AccountRequestDto accountRequestDto) {
        Account account = accountRepository.findById(id).get();
        if (accountRequestDto.getUsername() != null && accountRequestDto.getUsername() != account.getUsername())
            account.setUsername(accountRequestDto.getUsername());
        if (accountRequestDto.getPassword() != null)
            account.setPassword(accountRequestDto.getPassword());
        return accountRepository.save(account);
    }

    @Override
    public void delete(Account account) {
        accountRepository.delete(account);
    }

    @Override
    public Account getByUsername(String username) {
        return accountRepository.findByUsername(username);
    }

    @Override
    public List<Account> getByRoleName(String role) {
        if (role.equalsIgnoreCase("USER"))
            return accountRepository.findAccountsByRoles(new Role(1L, ERole.USER));
        else if (role.equalsIgnoreCase("ADMIN"))
            return accountRepository.findAccountsByRoles(new Role(2L, ERole.ADMIN));
        else return null;
    }

    @Override
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }


}
