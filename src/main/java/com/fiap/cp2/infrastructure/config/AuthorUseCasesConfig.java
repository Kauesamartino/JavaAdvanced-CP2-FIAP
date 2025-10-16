package com.fiap.cp2.infrastructure.config;

import com.fiap.cp2.application.usecase.author.*;
import com.fiap.cp2.domain.repository.AuthorRepository;
import com.fiap.cp2.domain.usecase.author.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AuthorUseCasesConfig {

    private final AuthorRepository authorRepository;

    public AuthorUseCasesConfig(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Bean
    public CreateAuthorUseCase createAuthorUseCase() {
        return new CreateAuthorUseCaseImpl(authorRepository, getAuthorByIdUseCase());
    }

    @Bean
    public GetAuthorByIdUseCase getAuthorByIdUseCase() {
        return new GetAuthorByIdUseCaseImpl(authorRepository);
    }

    @Bean
    public ListAuthorsUseCase listAuthorsUseCase() {
        return  new ListAuthorsUseCaseImpl(authorRepository);
    }

    @Bean
    public UpdateAuthorUseCase updateAuthorUseCase() {
        return new UpdateAuthorUseCaseImpl(authorRepository, getAuthorByIdUseCase());
    }

    @Bean
    public DeleteAuthorUseCase deleteAuthorUseCase() {
        return new DeleteAuthorUseCaseImpl(authorRepository);
    }

}
