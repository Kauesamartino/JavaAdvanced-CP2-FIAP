package com.fiap.cp2.mappers;

import com.fiap.cp2.dto.AuthorOutDto;
import com.fiap.cp2.dto.BookInDto;
import com.fiap.cp2.dto.BookOutDto;
import com.fiap.cp2.entities.Book;

public final class BookMapper {
    public static BookOutDto toOutDto(Book book) {

        AuthorOutDto authorOutDto = new AuthorOutDto(
                book.getAuthor().getId(),
                book.getAuthor().getNome(),
                book.getAuthor().getEmail()
        );

        return new BookOutDto(
                book.getId(),
                book.getTitle(),
                book.getIsbn(),
                authorOutDto
        );
    }

    public static Book toEntity(BookInDto book) {
        return new Book(
                book.title(),
                book.isbn(),
                book.authorId()
        );
    }
}
