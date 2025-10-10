package com.fiap.cp2.application.usecase.author;

import com.fiap.cp2.domain.model.Author;
import com.fiap.cp2.domain.repository.AuthorRepository;
import com.fiap.cp2.domain.usecase.author.GetAuthorByIdUseCase;

public final class GetAuthorByIdUseCaseImpl implements GetAuthorByIdUseCase {

    private final AuthorRepository authorRepository;

    public GetAuthorByIdUseCaseImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Author execute(Long id) {
        return authorRepository.findById(id);
    }
}
