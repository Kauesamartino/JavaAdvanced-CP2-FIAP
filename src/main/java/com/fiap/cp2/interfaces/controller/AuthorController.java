package com.fiap.cp2.interfaces.controller;

import com.fiap.cp2.interfaces.dto.AuthorInDto;
import com.fiap.cp2.interfaces.dto.AuthorOutDto;
import com.fiap.cp2.interfaces.dto.AuthorResumeOutDto;

import java.util.List;

/**
 * Interface pura para o controller de Cliente, seguindo os princípios da Clean Architecture.
 * Esta interface define as operações disponíveis sem acoplamento com frameworks externos.
 */
public interface AuthorController {

    /**
     * Create new author
     *
     * @param authorInDto data of the author to be created
     * @return data of the created author
     */
    AuthorOutDto createAuthor(AuthorInDto authorInDto);

    /**
     * List all authors
     *
     * @return list of authors
     */
    List<AuthorResumeOutDto> listAuthors();

    /**
     * Get author by ID
     *
     * @param id ID of the author
     * @return data of the author
     */
    AuthorOutDto getAuthorById(Long id);

    /**
     * Delete author by ID
     *
     * @param id ID of the author
     */
    void deleteAuthor(Long id);

    /**
     * Update author
     *
     * @param authorInDto data of the author to be updated
     * @return data of the updated author
     */
    AuthorOutDto updateAuthor(AuthorInDto authorInDto);
}
