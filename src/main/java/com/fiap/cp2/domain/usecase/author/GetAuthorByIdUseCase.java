package com.fiap.cp2.domain.usecase.author;

import com.fiap.cp2.domain.model.Author;

public interface GetAuthorByIdUseCase {
    Author execute(Long id);
}
