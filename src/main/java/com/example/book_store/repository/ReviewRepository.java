package com.example.book_store.repository;

import com.example.book_store.model.entity.Book;
import com.example.book_store.model.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    List<Review> findReviewsByUser_Account_Username(String username);

    List<Review> findReviewsByBook_Title(String title);

    @Query("SELECT r FROM Review r LEFT JOIN FETCH r.book LEFT JOIN FETCH r.user")
    List<Review> getAllReviews();

    @Query("SELECT r FROM Review r JOIN FETCH r.reviews review LEFT JOIN FETCH r.user  WHERE review.id = :id")
    List<Review> getAnswerByReviewId(Long id);

    @Query("SELECT r FROM Review r JOIN FETCH r.reviewAnswers ra LEFT JOIN FETCH r.user WHERE ra.id = :id")
    List<Review> getReviewsByAnswerId(Long id);

}
