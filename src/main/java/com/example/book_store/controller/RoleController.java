package com.example.book_store.controller;

import com.example.book_store.model.entity.Role;
import com.example.book_store.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/roles")
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;

    @GetMapping("/all-roles")
    public List<Role> getAllRoles(){
        return roleService.getAllRoles();
    }
}
