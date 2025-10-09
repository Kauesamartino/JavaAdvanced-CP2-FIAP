package com.fiap.cp2.dto;

/**
 * DTO for creating a new Book
 */
public record BookInDto(
        String title,
        String isbn,
        Long authorId
) {
}
