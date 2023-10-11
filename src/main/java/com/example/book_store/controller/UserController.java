package com.example.book_store.controller;

import com.example.book_store.model.dto.request.SignUpRequestDto;
import com.example.book_store.model.dto.request.UserRequestDto;
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

    @PostMapping
    public void add(@RequestBody @Valid SignUpRequestDto signUpRequestDto){
        userService.add(signUpRequestDto);
    }

    @PatchMapping("/{id}/{reviewId}")
    public void addReview(@PathVariable Long id, @PathVariable Long reviewId){
        userService.addReview(id, reviewId);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id,
                       @RequestBody UserRequestDto userRequestDto){
        userService.update(id, userRequestDto);
    }

    @DeleteMapping
    public void delete(@RequestParam String username){
        userService.delete(username);
    }

    @GetMapping("/all-users")
    public List<User> getAllUsers(@RequestParam(defaultValue = "0") int page,
                                             @RequestParam(defaultValue = "2") int size){
       return userService.getAllUsers(page, size);
    }

    @GetMapping("/get-by-id/{id}")
    public User getById(@PathVariable Long id){
        return userService.getById(id);
    }

    @GetMapping("/get-by-username")
    public User getByUsername(@RequestParam String username){
        return userService.findUserByUsername(username);
    }


}
