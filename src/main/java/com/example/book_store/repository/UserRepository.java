package com.example.book_store.repository;

import com.example.book_store.model.entity.Review;
import com.example.book_store.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findUserByAccount_Username(@Param(value = "username") String username);

    boolean existsByReviews(Review review);
}
