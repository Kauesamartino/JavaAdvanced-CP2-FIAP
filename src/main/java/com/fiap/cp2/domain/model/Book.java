package com.fiap.cp2.domain.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Book {

    private String title;

    private String isbn;

    private Long authorId;

    public Book(String title, String isbn, Long authorId) {
        this.title = title;
        this.isbn = isbn;
        this.authorId = authorId;
    }

    public Book() {
    }
}
