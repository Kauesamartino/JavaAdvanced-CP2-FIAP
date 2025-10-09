package com.fiap.cp2.dto;

import com.fiap.cp2.entities.Book;

import java.util.List;

/**
 * DTO de saída para Autor com seus livros
 */
public record AuthorBooksOutDto(
        Long id,
        String name,
        String email,
        List<Book> books
) {
}
