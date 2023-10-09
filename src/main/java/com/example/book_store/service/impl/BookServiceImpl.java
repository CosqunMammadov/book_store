package com.example.book_store.service.impl;

import com.example.book_store.model.dto.request.BookRequestDto;
import com.example.book_store.model.entity.Book;
import com.example.book_store.model.entity.Review;
import com.example.book_store.repository.BookRepository;
import com.example.book_store.service.BookService;
import com.example.book_store.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final ReviewService reviewService;

    @Override
    public void add(BookRequestDto bookRequestDto) {
        Book book = Book.builder()
                .title(bookRequestDto.getTitle())
                .synopsis(bookRequestDto.getSynopsis())
                .build();
        bookRepository.save(book);
    }

    @Override
    public Book update(Long id, BookRequestDto bookRequestDto) {
        Book book = bookRepository.findById(id).get();
        if (bookRequestDto.getTitle() != null)
            book.setTitle(bookRequestDto.getTitle());
        if (bookRequestDto.getSynopsis() != null)
            book.setSynopsis(bookRequestDto.getSynopsis());
        return bookRepository.save(book);
    }

    @Override
    public void delete(Long id) {
        Book book = bookRepository.findById(id).get();
        Set<Review> reviews = book.getReviews();
        book.setReviews(null);
        bookRepository.delete(book);
        reviewService.deleteAll(reviews);
    }

    @Override
    public Book getById(Long id) {
        return bookRepository.findById(id).get();
    }

    @Override
    public Book getBookByTitle(String title) {
        return bookRepository.findByTitle(title);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
}
