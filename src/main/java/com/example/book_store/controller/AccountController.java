package com.example.book_store.controller;

import com.example.book_store.model.entity.Account;
import com.example.book_store.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService accountService;

    @GetMapping("/get-by-username")
    public Account getByUsername(@RequestParam String username){
        return accountService.findByUsername(username);
    }

    @GetMapping("/get-by-role-name/{role}")
    public List<Account> getByRoleName(@PathVariable String role){
        return accountService.getByRoleName(role);
    }

    @GetMapping("/all-accounts")
    public List<Account> getAllAccounts(){
        return accountService.getAllAccounts();
    }

}
