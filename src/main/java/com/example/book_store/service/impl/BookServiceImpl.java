package com.example.book_store.service.impl;

import com.example.book_store.model.dto.request.BookRequestDto;
import com.example.book_store.model.entity.Book;
import com.example.book_store.repository.BookRepository;
import com.example.book_store.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public void add(BookRequestDto bookRequestDto) {
        Book book = Book.builder()
                .title(bookRequestDto.getTitle())
                .synopsis(bookRequestDto.getSynopsis())
                .build();
        bookRepository.save(book);
    }

    @Override
    public Book findById(Long id) {
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
