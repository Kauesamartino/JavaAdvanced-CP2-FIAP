package com.fiap.cp2.dto;

import com.fiap.cp2.entities.Book;

import java.util.List;

public record AuthorBooksOutDto(
        Long id,
        String name,
        String email,
        List<Book> books
) {
}
