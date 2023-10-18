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
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final UserService userService;
    private final BookService bookService;

    @Override
    public void add(ReviewRequestDto reviewRequestDto) {
        Book book = bookService.getById(reviewRequestDto.getBookId());
        User user = userService.getById(reviewRequestDto.getUserId());
        Review review = Review.builder()
                .reviewText(reviewRequestDto.getReviewText())
                .book(book)
                .user(user)
                .numberOfLikes(0)
                .build();
        reviewRepository.save(review);
    }

    public Review update(Long id, ReviewRequestDto reviewRequestDto) {
        Review review = reviewRepository.findById(id).get();
        if (reviewRequestDto.getReviewText() != null)
            review.setReviewText(reviewRequestDto.getReviewText());
        if (reviewRequestDto.getBookId() != null)
            review.getBook().setId(reviewRequestDto.getBookId());
        if (reviewRequestDto.getUserId() != null)
            review.getUser().setId(reviewRequestDto.getUserId());
        return reviewRepository.save(review);
    }

    @Override
    public void delete(Long id) {
        Review review = reviewRepository.findById(id).get();
        review.setBook(null);
        reviewRepository.delete(review);
    }

    @Override
    public void deleteAll(Set<Review> reviews) {
        reviews.forEach(r -> r.setBook(null));
        reviewRepository.deleteAll(reviews);
    }

    @Override
    public List<Review> getByUsername(String username) {
        return reviewRepository.findReviewsByUser_Account_Username(username);
    }

    @Override
    public List<ReviewResponseDto> getByBookTitle(String title) {
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
    public Review getById(Long id) {
        return reviewRepository.findById(id).get();
    }

    @Override
    public List<Review> getAllReviews() {
        List<Review> reviewList =  reviewRepository.findAll();

//        List<Review> reviewList = reviewRepository.getAllReviews();
//        List<Book> bookList = new LinkedList<>();

        reviewList.forEach(review -> System.out.println(review.getBook()));

        return reviewList;
    }

    @Override
    public void calculateLikes(Long id, boolean like) {
        Review review = reviewRepository.findById(id).get();
        if (like)
            review.setNumberOfLikes(review.getNumberOfLikes() + 1);
        reviewRepository.save(review);
    }

}
