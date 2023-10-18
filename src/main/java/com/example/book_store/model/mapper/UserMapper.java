package com.example.book_store.model.mapper;

import com.example.book_store.model.dto.request.SignUpRequestDto;
import com.example.book_store.model.dto.response.UserResponseDto;
import com.example.book_store.model.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User signUpRequestDtoToUser(SignUpRequestDto signUpRequestDto);

    UserResponseDto userToUserResponseDto(User user);
}
