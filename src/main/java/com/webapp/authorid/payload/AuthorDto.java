package com.webapp.authorid.payload;

import lombok.Data;

@Data
public class AuthorDto {
    private Long id;

    private String name;
    private String email;
}
