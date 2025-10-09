package com.fiap.cp2.services;

import com.fiap.cp2.entities.Author;
import com.fiap.cp2.entities.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AuthorService {
    Page<Author> findAll(Pageable pageable);

    Author saveOrUpdate(Author author);

    Author findById(Long id);

    void deleteById(Long id);

    List<Book> findByIdBooks(Long id);
}
