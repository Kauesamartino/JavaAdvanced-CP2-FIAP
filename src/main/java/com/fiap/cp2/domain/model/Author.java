package com.fiap.cp2.domain.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Author {
    private Long id;

    private String name;

    private String email;

    public Author(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public Author(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public Author() {
    }
}
