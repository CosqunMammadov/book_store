package com.example.book_store.model.dto.response;

import com.example.book_store.model.entity.Account;
import com.example.book_store.model.entity.Review;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDto {
    String firstName;
    String lastName;
    String email;
    String contactNumber;
    Account account;
}
