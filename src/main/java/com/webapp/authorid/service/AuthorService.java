package com.webapp.authorid.service;

import com.webapp.authorid.payload.AuthorDto;

public interface AuthorService {
    AuthorDto createAuthor(AuthorDto authorDto, long addressId);
}
