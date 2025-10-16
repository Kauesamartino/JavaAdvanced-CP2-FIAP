package com.fiap.cp2.infrastructure.config;

import com.fiap.cp2.domain.usecase.author.*;
import com.fiap.cp2.interfaces.controller.AuthorController;
import com.fiap.cp2.interfaces.controller.AuthorControllerImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ControllersConfig {

    @Bean
    public AuthorController authorController(
            CreateAuthorUseCase createAuthorUseCase,
            DeleteAuthorUseCase deleteAuthorUseCase,
            GetAuthorByIdUseCase getAuthorByIdUseCase,
            ListAuthorsUseCase listAuthorsUseCase,
            UpdateAuthorUseCase updateAuthorUseCase
    ) {
        return new AuthorControllerImpl(
                createAuthorUseCase,
                listAuthorsUseCase,
                getAuthorByIdUseCase,
                deleteAuthorUseCase,
                updateAuthorUseCase
        );
    }

}
