package com.fiap.cp2.mappers;

import com.fiap.cp2.dto.AuthorOutDto;
import com.fiap.cp2.entities.Author;

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
}
