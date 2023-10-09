package com.example.book_store.controller;

import com.example.book_store.model.dto.request.BookRequestDto;
import com.example.book_store.model.entity.Book;
import com.example.book_store.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @PostMapping("/add-book")
    public void add(@RequestBody BookRequestDto bookRequestDto){
        bookService.add(bookRequestDto);
    }

    @GetMapping("/get-book/{title}")
    public Book getByTitle(@PathVariable String title){
        return bookService.getBookByTitle(title);
    }

    @GetMapping("/all-books")
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }
}
