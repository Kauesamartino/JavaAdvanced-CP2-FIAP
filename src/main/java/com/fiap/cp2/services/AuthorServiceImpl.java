package com.fiap.cp2.services;

import com.fiap.cp2.entities.Author;
import com.fiap.cp2.exceptions.EntityNotFound;
import com.fiap.cp2.repositories.AuthorRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Page<Author> findAll(Pageable pageable) {
        return this.authorRepository.findAll(pageable);
    }

    @Override
    public Author saveOrUpdate(Author author) {
        return this.authorRepository.save(author);
    }

    @Override
    @Transactional(readOnly = true)
    public Author findById(Long id) {
        return this.authorRepository.findById(id).orElseThrow(() -> new EntityNotFound("Page not found"));
    }
}
