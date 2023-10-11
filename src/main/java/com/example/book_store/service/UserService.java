package com.example.book_store.service;

import com.example.book_store.model.dto.request.SignUpRequestDto;
import com.example.book_store.model.dto.request.UserRequestDto;
import com.example.book_store.model.entity.Review;
import com.example.book_store.model.entity.User;

import java.util.List;

public interface UserService {

    void add(SignUpRequestDto signUpRequestDto);

    User update(Long id, UserRequestDto userRequestDto);

    void delete(String username);

    User getById(Long id);

    User findUserByUsername(String username);

    List<User> getAllUsers(int page, int size);

    void addReview(Long id, Long reviewId);

}
