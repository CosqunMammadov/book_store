package com.example.book_store.service;

import com.example.book_store.model.entity.Role;
import com.example.book_store.model.enums.ERole;
import org.springframework.stereotype.Service;

import java.util.List;


public interface RoleService {
    Role findByRoleName(ERole eRole);

    List<Role> getAllRoles();
}
