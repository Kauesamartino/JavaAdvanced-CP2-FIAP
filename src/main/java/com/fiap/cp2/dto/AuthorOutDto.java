package com.fiap.cp2.dto;

/**
 * DTO de saída para autor
 */
public record AuthorOutDto(
        Long id,
        String name,
        String email
) {
}
