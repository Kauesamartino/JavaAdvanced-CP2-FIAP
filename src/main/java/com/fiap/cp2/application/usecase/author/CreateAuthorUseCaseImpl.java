package com.fiap.cp2.application.usecase.author;

import com.fiap.cp2.application.exception.AuthorUnsupportedOperation;
import com.fiap.cp2.application.exception.EntityNotFound;
import com.fiap.cp2.domain.model.Author;
import com.fiap.cp2.domain.repository.AuthorRepository;
import com.fiap.cp2.domain.usecase.author.CreateAuthorUseCase;
import com.fiap.cp2.domain.usecase.author.GetAuthorByIdUseCase;

public final class CreateAuthorUseCaseImpl implements CreateAuthorUseCase {

    private final AuthorRepository authorRepository;
    private final GetAuthorByIdUseCase getAuthorByIdUseCase;

    public CreateAuthorUseCaseImpl(AuthorRepository authorRepository, GetAuthorByIdUseCase getAuthorByIdUseCase) {
        this.authorRepository = authorRepository;
        this.getAuthorByIdUseCase = getAuthorByIdUseCase;
    }

    @Override
    public Author execute(Author author) {
        try{
            getAuthorByIdUseCase.execute(author.getId());
        } catch (EntityNotFound e){
            return authorRepository.save(author);
        }
        throw new AuthorUnsupportedOperation("Author already exists");
    }
}
