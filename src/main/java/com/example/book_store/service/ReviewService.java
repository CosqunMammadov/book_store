package com.example.book_store.service;

import com.example.book_store.model.dto.request.ReviewRequestDto;
import com.example.book_store.model.dto.response.ReviewResponseDto;
import com.example.book_store.model.entity.Review;

import java.util.List;
import java.util.Set;

public interface ReviewService {

    void add(ReviewRequestDto reviewRequestDto);

    Review update(Long id, ReviewRequestDto reviewRequestDto);

    void delete(Long id);

    void deleteAll(Set<Review> reviews);

    List<Review> getReviewsByUsername(String username);

    List<ReviewResponseDto> getReviewsByBookTitle(String title);

    List<Review> getAllReviews();
}
