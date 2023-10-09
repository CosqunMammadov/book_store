package com.example.book_store.service.impl;

import com.example.book_store.model.dto.request.AccountRequestDto;
import com.example.book_store.model.dto.request.SignUpRequestDto;
import com.example.book_store.model.entity.Account;
import com.example.book_store.model.entity.Role;
import com.example.book_store.model.enums.ERole;
import com.example.book_store.repository.AccountRepository;
import com.example.book_store.service.AccountService;
import com.example.book_store.service.RoleService;
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
    public Account findByUsername(String username) {
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


}
