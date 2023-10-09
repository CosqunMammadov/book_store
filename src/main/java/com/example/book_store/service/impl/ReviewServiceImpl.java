package com.example.book_store.service.impl;

import com.example.book_store.model.dto.request.ReviewRequestDto;
import com.example.book_store.model.dto.response.ReviewResponseDto;
import com.example.book_store.model.entity.Book;
import com.example.book_store.model.entity.Review;
import com.example.book_store.model.entity.User;
import com.example.book_store.repository.ReviewRepository;
import com.example.book_store.service.BookService;
import com.example.book_store.service.ReviewService;
import com.example.book_store.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final UserService userService;
    private final BookService bookService;

    @Override
    public void add(ReviewRequestDto reviewRequestDto) {
        Book book = bookService.findById(reviewRequestDto.getBookId());
        User user = userService.findById(reviewRequestDto.getUserId());
        Review review = Review.builder()
                .reviewText(reviewRequestDto.getReviewText())
                .book(book)
                .user(user)
                .build();
        reviewRepository.save(review);
    }

    @Override
    public List<Review> getReviewsByUsername(String username) {
        return reviewRepository.findReviewsByUser_Account_Username(username);
    }

    @Override
    public List<ReviewResponseDto> getReviewsByBookTitle(String title) {
        List<Review> reviews = reviewRepository.findReviewsByBook_Title(title);
        List<ReviewResponseDto> reviewResponseList = new LinkedList<>();

        reviews.forEach(review -> reviewResponseList.add(ReviewResponseDto.builder()
                .firstName(review.getUser().getFirstName())
                .lastName(review.getUser().getLastName())
                .reviewText(review.getReviewText())
                .reviewDate(review.getReviewDate())
                .build()));
        return reviewResponseList;
    }

    @Override
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

}
