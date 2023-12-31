package com.example.book_store.service;

import com.example.book_store.model.dto.request.BookRequestDto;
import com.example.book_store.model.entity.Book;

import java.util.List;

public interface BookService {

    void add(BookRequestDto bookRequestDto);

    Book update(Long id, BookRequestDto bookRequestDto);

    void delete(Long id);

    Book getById(Long id);

    Book getBookByTitle(String title);

    List<Book> getAllBooks();
}
