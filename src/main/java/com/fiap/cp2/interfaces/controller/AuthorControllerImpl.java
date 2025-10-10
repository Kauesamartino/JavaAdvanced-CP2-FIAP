package com.fiap.cp2.interfaces.controller;

import com.fiap.cp2.domain.model.Author;
import com.fiap.cp2.domain.usecase.author.*;
import com.fiap.cp2.interfaces.dto.AuthorInDto;
import com.fiap.cp2.interfaces.dto.AuthorOutDto;
import com.fiap.cp2.interfaces.dto.AuthorResumeOutDto;
import com.fiap.cp2.interfaces.mapper.AuthorMapper;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementation of the Author controller without coupling to external frameworks.
 * Follows Clean Architecture principles, acting as an adapter between use cases and the external interface.
 */
public class AuthorControllerImpl implements AuthorController {

    private final CreateAuthorUseCase createAuthorUseCase;
    private final ListAuthorsUseCase listAuthorsUseCase;
    private final GetAuthorByIdUseCase getAuthorByIdUseCase;
    private final DeleteAuthorUseCase deleteAuthorUseCase;
    private final UpdateAuthorUseCase updateAuthorUseCase;

    public AuthorControllerImpl(CreateAuthorUseCase createAuthorUseCase, ListAuthorsUseCase listAuthorsUseCase, GetAuthorByIdUseCase getAuthorByIdUseCase, DeleteAuthorUseCase deleteAuthorUseCase, UpdateAuthorUseCase updateAuthorUseCase) {
        this.createAuthorUseCase = createAuthorUseCase;
        this.listAuthorsUseCase = listAuthorsUseCase;
        this.getAuthorByIdUseCase = getAuthorByIdUseCase;
        this.deleteAuthorUseCase = deleteAuthorUseCase;
        this.updateAuthorUseCase = updateAuthorUseCase;
    }

    @Override
    public AuthorOutDto createAuthor(AuthorInDto authorInDto) {
        Author author = AuthorMapper.toModel(authorInDto);
        Author createdAuthor = createAuthorUseCase.execute(author);
        return AuthorMapper.toOutDto(createdAuthor);
    }

    @Override
    public List<AuthorResumeOutDto> listAuthors() {
        List<Author> authors = listAuthorsUseCase.execute();

        return authors.stream()
                .sorted(Comparator.comparing(Author::getName))
                .map(AuthorMapper::toResumeOutDto)
                .collect(Collectors.toList());
    }

    @Override
    public AuthorOutDto getAuthorById(Long id) {
        Author author = getAuthorByIdUseCase.execute(id);
        return AuthorMapper.toOutDto(author);
    }

    @Override
    public void deleteAuthor(Long id) {
        deleteAuthorUseCase.execute(id);
    }

    @Override
    public AuthorOutDto updateAuthor(AuthorInDto authorInDto) {
        Author author = AuthorMapper.toModel(authorInDto);
        Author updatedAuthor = updateAuthorUseCase.execute(author);
        return AuthorMapper.toOutDto(updatedAuthor);
    }
}
