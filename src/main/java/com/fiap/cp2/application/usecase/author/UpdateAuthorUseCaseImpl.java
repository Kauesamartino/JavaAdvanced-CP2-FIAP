package com.fiap.cp2.application.usecase.author;

import com.fiap.cp2.application.exception.AuthorUnsupportedOperation;
import com.fiap.cp2.application.exception.EntityNotFound;
import com.fiap.cp2.domain.model.Author;
import com.fiap.cp2.domain.repository.AuthorRepository;
import com.fiap.cp2.domain.usecase.author.GetAuthorByIdUseCase;
import com.fiap.cp2.domain.usecase.author.UpdateAuthorUseCase;

public final class UpdateAuthorUseCaseImpl implements UpdateAuthorUseCase {

    private final AuthorRepository authorRepository;
    private final GetAuthorByIdUseCase getAuthorByIdUseCase;

    public UpdateAuthorUseCaseImpl(AuthorRepository authorRepository, GetAuthorByIdUseCase getAuthorByIdUseCase) {
        this.authorRepository = authorRepository;
        this.getAuthorByIdUseCase = getAuthorByIdUseCase;
    }

    @Override
    public Author execute(Author author) {
        try{
            getAuthorByIdUseCase.execute(author.getId());
        } catch (EntityNotFound e){
            throw new AuthorUnsupportedOperation("Author not found");
        }
        return authorRepository.update(author);
    }
}
