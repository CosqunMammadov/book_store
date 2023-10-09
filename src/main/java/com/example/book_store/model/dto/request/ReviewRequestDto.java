package com.example.book_store.model.dto.request;

import com.example.book_store.model.entity.Book;
import com.example.book_store.model.entity.User;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ReviewRequestDto {

    String reviewText;
    Long bookId;
    Long userId;
}
