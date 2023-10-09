package com.example.book_store.model.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "first_name")
    String firstName;

    @Column(name = "last_name")
    String lastName;

    @Column(name = "email")
    String email;

    @Column(name = "contact_number")
    String contactNumber;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id")
    Account account;

    @OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST)
    Set<Review> reviews;

    @JsonManagedReference
    public Set<Review> getReviews() {
        return reviews;
    }
}
