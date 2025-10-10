package com.fiap.cp2.application.usecase.author;

import com.fiap.cp2.domain.model.Author;
import com.fiap.cp2.domain.repository.AuthorRepository;
import com.fiap.cp2.domain.usecase.author.ListAuthorsUseCase;

import java.util.List;

public final class ListAuthorsUseCaseImpl implements ListAuthorsUseCase {

    private final AuthorRepository authorRepository;

    public ListAuthorsUseCaseImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }


    @Override
    public List<Author> execute() {
        return authorRepository.findAll();
    }
}
