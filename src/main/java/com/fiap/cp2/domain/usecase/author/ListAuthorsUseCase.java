package com.fiap.cp2.domain.usecase.author;

import com.fiap.cp2.domain.model.Author;

import java.util.List;

public interface ListAuthorsUseCase {
    List<Author> execute();
}
