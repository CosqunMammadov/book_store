package com.example.book_store.model.dto.request;

import com.example.book_store.model.entity.Book;
import com.example.book_store.model.entity.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ReviewRequestDto {

    @NotBlank
    String reviewText;

    Long reviewId;

    @NotNull
    Long bookId;
    Long userId;
}
