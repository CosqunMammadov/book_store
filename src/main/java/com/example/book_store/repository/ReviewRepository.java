package com.example.book_store.repository;

import com.example.book_store.model.entity.Book;
import com.example.book_store.model.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    List<Review> findReviewsByUser_Account_Username(String username);

    List<Review> findReviewsByBook_Title(String title);


}
