package com.example.book_store.service.impl;

import com.example.book_store.model.entity.Role;
import com.example.book_store.model.enums.ERole;
import com.example.book_store.repository.RoleRepository;
import com.example.book_store.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Override
    public Role findByRoleName(ERole eRole) {
        return roleRepository.findByRoleName(eRole);
    }

    public List<Role> getAllRoles(){
        return roleRepository.findAll();
    }
}
