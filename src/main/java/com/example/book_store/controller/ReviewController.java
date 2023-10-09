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

    @PostMapping
    public void add(@RequestBody ReviewRequestDto reviewRequestDto){
        reviewService.add(reviewRequestDto);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id,
                       @RequestBody ReviewRequestDto reviewRequestDto){
        reviewService.update(id, reviewRequestDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        reviewService.delete(id);
    }

    @GetMapping("/get-by-username")
    public List<Review> getByUsername(@RequestParam String username){
        return reviewService.getReviewsByUsername(username);
    }

    @GetMapping("/get-by-book-title")
    public List<ReviewResponseDto> getByBookTitle(@RequestParam String title){
        return reviewService.getReviewsByBookTitle(title);
    }

    @GetMapping("/all-reviews")
    public List<Review> getAllReviews(){
        return reviewService.getAllReviews();
    }
}
