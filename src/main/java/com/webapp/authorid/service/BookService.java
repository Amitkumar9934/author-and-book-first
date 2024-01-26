package com.webapp.authorid.service;

import com.webapp.authorid.payload.BookDto;

public interface BookService {
    BookDto createBook(BookDto bookDto,long authorId);
}
