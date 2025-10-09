package com.fiap.cp2.dto;

public record BookOutDto(
        Long id,
        String title,
        String isbn,
        AuthorOutDto author
) {
}
