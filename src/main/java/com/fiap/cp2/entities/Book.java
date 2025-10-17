package com.fiap.cp2.entities;

import com.fiap.cp2.exceptions.ValidacaoDominioException;
import jakarta.persistence.*;


@Entity
public class Book {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String isbn;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Author author;

    public Book(String title, String isbn, Long authorId) {
        setTitle(title);
        setIsbn(isbn);
        this.author = new Author();
        this.author.setId(authorId);
    }

    public Book() {

    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getIsbn() {
        return isbn;
    }

    public Author getAuthor() {
        return author;
    }

    public void setTitle(String title) {
        this.title = title;
        isTitleValido();
    }

    private void isTitleValido() {
        //valida se nome é nulo, vazio ou em branco
        if (title == null || title.isEmpty()) {
            throw new ValidacaoDominioException("Nome vazio");
        }

        //valida se a palavra tem no minimo 3 caracteres
        if(title.length() < 3){
            throw new ValidacaoDominioException("Nome deve ter pelo menos 3 caracteres");
        }
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
        isIsbnValido();
    }

    private void isIsbnValido() {
        final String regex = "^97[89]-?\\d{1,5}-?\\d{1,7}-?\\d{1,6}-?\\d$";
        if (!isbn.matches(regex)) {
            throw new ValidacaoDominioException("Email inválido");
        }
    }

    public void setAuthor(Author author) {
        this.author = author;
        isAuthorValido();
    }

    private void isAuthorValido() {
        if (author == null || author.getId() == null) {
            throw new ValidacaoDominioException("Autor inválido");
        }
    }
}
