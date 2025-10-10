package com.fiap.cp2.domain.repository;

import com.fiap.cp2.domain.model.Author;

import java.util.List;

public interface AuthorRepository {

    Author save(Author author);

    Author findById(Long id);

    List<Author> findAll();

    Author update(Author author);

    Author delete(Long id);
}
