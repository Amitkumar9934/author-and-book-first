package com.webapp.authorid.repository;

import com.webapp.authorid.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {
}
