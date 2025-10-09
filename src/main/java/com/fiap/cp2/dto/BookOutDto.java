package com.fiap.cp2.dto;

/**
 * DTO de saída para livro
 */
public record BookOutDto(
        Long id,
        String title,
        String isbn,
        AuthorOutDto author
) {
}
