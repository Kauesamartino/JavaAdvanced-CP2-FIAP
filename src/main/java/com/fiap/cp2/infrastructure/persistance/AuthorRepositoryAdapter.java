package com.fiap.cp2.infrastructure.persistance;

import com.fiap.cp2.domain.model.Author;
import com.fiap.cp2.domain.repository.AuthorRepository;
import com.fiap.cp2.infrastructure.repository.JpaAuthorRepository;

import java.util.List;

public class AuthorRepositoryAdapter implements AuthorRepository {
    public AuthorRepositoryAdapter(JpaAuthorRepository jpaAuthorRepository) {
    }

    @Override
    public Author save(Author author) {
        return null;
    }

    @Override
    public Author findById(Long id) {
        return null;
    }

    @Override
    public List<Author> findAll() {
        return List.of();
    }

    @Override
    public Author update(Author author) {
        return null;
    }

    @Override
    public Author delete(Long id) {
        return null;
    }
}
