package com.example.book_store.controller;

import com.example.book_store.model.dto.request.SignUpRequestDto;
import com.example.book_store.model.entity.User;
import com.example.book_store.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/all-users")
    public List<User> getAllUsers(@RequestParam(defaultValue = "0") int page,
                                             @RequestParam(defaultValue = "2") int size){
       return userService.getAllUsers(page, size);
    }

    @GetMapping("/get-by-id")
    public User getById(@RequestParam Long id){
        return userService.findById(id);
    }

    @GetMapping("/get-by-username")
    public User getByUsername(@RequestParam String username){
        return userService.findUserByUsername(username);
    }

    @PostMapping("/add-user")
    public void addUser(@RequestBody @Valid SignUpRequestDto signUpRequestDto){
        userService.add(signUpRequestDto);
    }
}
