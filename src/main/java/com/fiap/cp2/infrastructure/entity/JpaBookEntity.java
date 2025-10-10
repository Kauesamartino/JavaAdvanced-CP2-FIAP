package com.fiap.cp2.infrastructure.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class JpaBookEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String isbn;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private JpaAuthorEntity author;

    public JpaBookEntity(Long id, String title, String isbn, JpaAuthorEntity author) {
        this.id = id;
        this.title = title;
        this.isbn = isbn;
        this.author = author;
    }

    public JpaBookEntity(String title, String isbn, JpaAuthorEntity author) {
        this.title = title;
        this.isbn = isbn;
        this.author = author;
    }

    public JpaBookEntity() {
    }
}
