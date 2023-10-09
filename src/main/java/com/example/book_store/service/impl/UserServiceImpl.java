package com.example.book_store.service.impl;

import com.example.book_store.model.dto.request.SignUpRequestDto;
import com.example.book_store.model.entity.Account;
import com.example.book_store.model.entity.User;
import com.example.book_store.repository.UserRepository;
import com.example.book_store.service.AccountService;
import com.example.book_store.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final AccountService accountService;

    public List<User> getAllUsers(int page, int size) {
        Pageable paging = PageRequest.of(page, size);
        List<User> users = userRepository.findAll(paging).getContent();
        return users;
    }


    @Override
    public void add(SignUpRequestDto signUpRequestDto) {
        Account account = accountService.add(signUpRequestDto);

        User user = User.builder()
                .firstName(signUpRequestDto.getFirstName())
                .lastName(signUpRequestDto.getLastName())
                .email(signUpRequestDto.getEmail())
                .contactNumber(signUpRequestDto.getContactNumber())
                .account(account)
                .build();
        userRepository.save(user);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public User findUserByUsername(String username) {
        return userRepository.findUserByAccount_Username(username);
    }


}
