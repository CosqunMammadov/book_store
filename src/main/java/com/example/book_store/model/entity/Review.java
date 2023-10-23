package com.example.book_store.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "reviews")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String reviewText;

    int numberOfLikes;


    @CreationTimestamp
    @Column(name = "review_date", columnDefinition = "timestamp default now()")
    LocalDateTime reviewDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    Book book;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    User user;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "reviews_answers",
            joinColumns = @JoinColumn(name = "review_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "answer_id", referencedColumnName = "id")
    )
    Set<Review> reviewAnswers;

    @ManyToMany(mappedBy = "reviewAnswers")
    Set<Review> reviews;

    @JsonBackReference
    public Book getBook(){
        return book;
    }

    @JsonBackReference
    public User getUser(){
        return user;
    }
}
