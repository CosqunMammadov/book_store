package com.example.book_store.service;

import com.example.book_store.model.dto.request.SignUpRequestDto;
import com.example.book_store.model.entity.User;

import java.util.List;

public interface UserService {

    void add(SignUpRequestDto signUpRequestDto);

    User findById(Long id);

    User findUserByUsername(String username);

    List<User> getAllUsers(int page, int size);
}
