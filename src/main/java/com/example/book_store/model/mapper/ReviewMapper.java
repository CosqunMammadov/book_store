package com.example.book_store.model.mapper;

import com.example.book_store.model.dto.request.ReviewRequestDto;
import com.example.book_store.model.dto.response.ReviewResponseDto;
import com.example.book_store.model.entity.Review;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReviewMapper {

    Review reviewRequestDtoToReview(ReviewRequestDto reviewRequestDto);

    ReviewResponseDto reviewToReviewResponseDto(Review review, String firstName, String lastName);
}
