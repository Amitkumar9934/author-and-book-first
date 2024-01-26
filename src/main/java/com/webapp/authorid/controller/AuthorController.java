package com.webapp.authorid.controller;

import com.webapp.authorid.entity.Author;
import com.webapp.authorid.payload.AuthorDto;
import com.webapp.authorid.service.AuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {

    private AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }
    @PostMapping
    public ResponseEntity<AuthorDto> createAuthor(@RequestBody AuthorDto authorDto, @RequestParam long addressId) {
        AuthorDto dto= authorService.createAuthor(authorDto,addressId);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }
}
