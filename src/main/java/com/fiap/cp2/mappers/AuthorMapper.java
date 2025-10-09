package com.fiap.cp2.mappers;

import com.fiap.cp2.dto.AuthorBooksOutDto;
import com.fiap.cp2.dto.AuthorInDto;
import com.fiap.cp2.dto.AuthorOutDto;
import com.fiap.cp2.entities.Author;
import com.fiap.cp2.entities.Book;

import java.util.List;

public final class AuthorMapper {

    public AuthorMapper() {
    }

    public static AuthorOutDto toOutDto(Author author) {
        return new AuthorOutDto(
                author.getId(),
                author.getNome(),
                author.getEmail()
        );
    }

    public static Author toEntity(AuthorInDto authorInDto) {
        return new Author(
                authorInDto.name(),
                authorInDto.email()
        );
    }

    public static AuthorBooksOutDto toAuthorBooksOutDto(Author author, List<Book> books) {
        return new AuthorBooksOutDto(
                author.getId(),
                author.getNome(),
                author.getEmail(),
                books
        );
    }
}
