package com.example.book_store.service.impl;

import com.example.book_store.model.dto.request.SignUpRequestDto;
import com.example.book_store.model.dto.request.UserRequestDto;
import com.example.book_store.model.entity.Account;
import com.example.book_store.model.entity.Review;
import com.example.book_store.model.entity.User;
import com.example.book_store.repository.UserRepository;
import com.example.book_store.service.AccountService;
import com.example.book_store.service.ReviewService;
import com.example.book_store.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final AccountService accountService;
    private final ReviewService reviewService;

    public UserServiceImpl(UserRepository userRepository, AccountService accountService, @Lazy ReviewService reviewService) {
        this.userRepository = userRepository;
        this.accountService = accountService;
        this.reviewService = reviewService;
    }

    public List<User> getAllUsers(int page, int size) {
        Pageable paging = PageRequest.of(page, size);
        List<User> users = userRepository.findAll(paging).getContent();
        return users;
    }

    @Override
    public void add(SignUpRequestDto signUpRequestDto) {
        Account account = accountService.add(signUpRequestDto);

        User user = User.builder()
                .firstName(signUpRequestDto.getFirstName())
                .lastName(signUpRequestDto.getLastName())
                .email(signUpRequestDto.getEmail())
                .contactNumber(signUpRequestDto.getContactNumber())
                .account(account)
                .build();
        userRepository.save(user);
    }

    @Override
    public User update(Long id, UserRequestDto userRequestDto) {
        User user = userRepository.findById(id).get();
        if (userRequestDto.getFirstName() != null)
            user.setFirstName(userRequestDto.getFirstName());
        if (userRequestDto.getLastName() != null)
            user.setLastName(userRequestDto.getLastName());
        if (userRequestDto.getEmail() != null)
            user.setEmail(userRequestDto.getEmail());
        if (userRequestDto.getContactNumber() != null)
            user.setContactNumber(userRequestDto.getContactNumber());
        return userRepository.save(user);
    }

    @Override
    public void delete(String username) {
        User user = findUserByUsername(username);
        Account account = user.getAccount();
        Set<Review> reviews = user.getReviews();
        reviews.forEach(r -> r.setUser(null));
        user.setAccount(null);
        userRepository.delete(user);
        accountService.delete(account);
    }

    @Override
    public User getById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public User findUserByUsername(String username) {
        return userRepository.findUserByAccount_Username(username);
    }

    @Override
    public void addReview(Long id, Long reviewId) {
        Review review = reviewService.getById(reviewId);
        if (!userRepository.existsByReviews(review)){
            User user = getById(id);
            user.getReviews().add(review);
            userRepository.save(user);
        }
    }
}
