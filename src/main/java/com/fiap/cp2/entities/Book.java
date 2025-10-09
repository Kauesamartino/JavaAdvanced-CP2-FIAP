package com.fiap.cp2.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Book {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String isbn;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Author author;

    public Book(String title, String isbn, Long authorId) {
        this.title = title;
        this.isbn = isbn;
        this.author = new Author();
        this.author.setId(authorId);
    }

    public Book() {

    }
}
