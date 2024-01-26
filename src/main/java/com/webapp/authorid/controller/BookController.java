package com.webapp.authorid.controller;

import com.webapp.authorid.payload.BookDto;
import com.webapp.authorid.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    @PostMapping
    public ResponseEntity<BookDto> createBook(@RequestBody BookDto bookDto, @RequestParam long authorId) {
        BookDto dto= bookService.createBook(bookDto,authorId);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }
}
