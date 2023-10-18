package com.example.book_store.model.dto.response;

import com.example.book_store.model.entity.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountResponseDto {

    String username;
    String password;
    boolean isActive;
    Set<Role> roles;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
}
