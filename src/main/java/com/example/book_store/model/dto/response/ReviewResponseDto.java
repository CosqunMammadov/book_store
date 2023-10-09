package com.example.book_store.model.dto.response;

import lombok.*;

import java.time.LocalDateTime;
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReviewResponseDto {
    String firstName;
    String lastName;
    String reviewText;
    LocalDateTime reviewDate;
}
