package com.webapp.authorid.service.impl;

import com.webapp.authorid.entity.Address;
import com.webapp.authorid.entity.Author;
import com.webapp.authorid.exception.ResourceNotFoundException;
import com.webapp.authorid.payload.AuthorDto;
import com.webapp.authorid.repository.AddressRepository;
import com.webapp.authorid.repository.AuthorRepository;
import com.webapp.authorid.service.AuthorService;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {
    private AuthorRepository authorRepository;
    private AddressRepository addressRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository, AddressRepository addressRepository) {
        this.authorRepository = authorRepository;
        this.addressRepository = addressRepository;
    }

    @Override
    public AuthorDto createAuthor(AuthorDto authorDto, long addressId) {
        Address address = addressRepository.findById(addressId).orElseThrow(
                () -> new ResourceNotFoundException("Address Not found with id" + addressId));
        //Author author = mapToEntity(authorDto);
        Author author = new Author();
        author.setName(authorDto.getName());
        author.setEmail(authorDto.getEmail());
        author.setAddress(address);

        Author saved = authorRepository.save(author);
        AuthorDto dto = mapToDto(saved);


        return dto;
    }
//    Author mapToEntity(AuthorDto authorDto){
//        Author author = new Author();
//        author.setName(authorDto.getName());
//        author.setEmail(authorDto.getEmail());
//        return author;
//    }
    AuthorDto mapToDto(Author author){
        AuthorDto dto = new AuthorDto();
        dto.setId(author.getId());
        dto.setName(author.getName());
        dto.setEmail(author.getEmail());
        return dto;

    }
}
