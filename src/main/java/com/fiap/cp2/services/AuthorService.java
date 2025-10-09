package com.fiap.cp2.services;

import com.fiap.cp2.entities.Author;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AuthorService {
    Page<Author> findAll(Pageable pageable);

    Author saveOrUpdate(Author author);

    Author findById(Long id);
}
