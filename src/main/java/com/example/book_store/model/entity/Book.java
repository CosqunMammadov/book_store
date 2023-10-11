package com.example.book_store.model.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Entity
@Table(name = "books")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String title;

    @Column(length = 500)
    String synopsis;

    @OneToMany(mappedBy = "book")
    Set<Review> reviews;

    @JsonManagedReference
    public Set<Review> getReviews(){
        return reviews;
    }
}
