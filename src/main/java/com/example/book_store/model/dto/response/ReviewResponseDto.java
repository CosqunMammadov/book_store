package com.example.book_store.model.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ReviewResponseDto {
    String firstName;
    String lastName;
    String reviewText;
    LocalDateTime reviewDate;
    int numberOfLikes;
}
