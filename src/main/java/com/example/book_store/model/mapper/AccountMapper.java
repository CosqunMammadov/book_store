package com.example.book_store.model.mapper;

import com.example.book_store.model.dto.request.SignUpRequestDto;
import com.example.book_store.model.dto.response.AccountResponseDto;
import com.example.book_store.model.entity.Account;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AccountMapper {

    @Mapping(target = "username", source = "signUpRequestDTO.username")
    Account signUpRequestDTOtoAccount(SignUpRequestDto signUpRequestDTO);

    AccountResponseDto accountToAccountResponseDTO(Account account);
}
