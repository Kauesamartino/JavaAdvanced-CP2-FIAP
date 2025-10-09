package com.fiap.cp2.dto;

public record BookInDto(
        String title,
        String isbn,
        Long authorId
) {
}
