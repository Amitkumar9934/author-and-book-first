package com.webapp.authorid.service.impl;

import com.webapp.authorid.entity.Author;
import com.webapp.authorid.entity.Book;
import com.webapp.authorid.exception.ResourceNotFoundException;
import com.webapp.authorid.payload.BookDto;
import com.webapp.authorid.repository.AuthorRepository;
import com.webapp.authorid.repository.BookRepository;
import com.webapp.authorid.service.BookService;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
    private BookRepository bookRepository;
    private AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }




    @Override
    public BookDto createBook(BookDto bookDto,long authorId) {
        Author author = authorRepository.findById(authorId).orElseThrow(
                () -> new ResourceNotFoundException("Post Not found with id" + authorId));
                Book book = new Book();
        book.setTitle(bookDto.getTitle());
        book.setAuthor(author);
        Book saved = bookRepository.save(book);
        BookDto dto = mapToDto(saved);
        return dto;

    }
//    Book mapToEntity(BookDto bookDto){
//        Book book = new Book();
//        book.setTitle(bookDto.getTitle());
//        book.setAuthor(authorId);
//        return book;
//    }
    BookDto mapToDto(Book book){
        BookDto dto = new BookDto();
        dto.setId(book.getId());
        dto.setTitle(book.getTitle());

        return dto;

    }
}
