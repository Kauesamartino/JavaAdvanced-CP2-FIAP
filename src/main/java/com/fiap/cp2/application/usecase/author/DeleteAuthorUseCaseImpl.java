package com.fiap.cp2.application.usecase.author;

import com.fiap.cp2.application.exception.AuthorUnsupportedOperation;
import com.fiap.cp2.application.exception.EntityNotFound;
import com.fiap.cp2.domain.repository.AuthorRepository;
import com.fiap.cp2.domain.usecase.author.DeleteAuthorUseCase;

public final class DeleteAuthorUseCaseImpl implements DeleteAuthorUseCase {

    private final AuthorRepository authorRepository;

    public DeleteAuthorUseCaseImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public void execute(Long id) {
        try{
            authorRepository.findById(id);
        } catch (EntityNotFound e){
            throw new AuthorUnsupportedOperation("Author not found");
        }
        authorRepository.delete(id);
    }
}
