package com.example.book_store.controller;

import com.example.book_store.model.dto.request.ReviewRequestDto;
import com.example.book_store.model.dto.response.ReviewResponseDto;
import com.example.book_store.model.entity.Review;
import com.example.book_store.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping("/add-review")
    public void add(@RequestBody ReviewRequestDto reviewRequestDto){
        reviewService.add(reviewRequestDto);
    }

    @GetMapping("/get-by-username/{username}")
    public List<Review> getByUsername(@PathVariable String username){
        return reviewService.getReviewsByUsername(username);
    }

    @GetMapping("/get-by-book-title/{title}")
    public List<ReviewResponseDto> getByBookTitle(@PathVariable String title){
        return reviewService.getReviewsByBookTitle(title);
    }

    @GetMapping("/all-reviews")
    public List<Review> getAllReviews(){
        return reviewService.getAllReviews();
    }
}
