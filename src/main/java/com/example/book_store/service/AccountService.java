package com.example.book_store.service;

import com.example.book_store.model.dto.request.AccountRequestDto;
import com.example.book_store.model.dto.request.SignUpRequestDto;
import com.example.book_store.model.entity.Account;
import com.example.book_store.model.enums.ERole;

import java.util.List;

public interface AccountService {

    Account add(SignUpRequestDto signUpRequestDto);

    Account findByUsername(String username);

    List<Account> getByRoleName(String role);

    List<Account> getAllAccounts();
}
