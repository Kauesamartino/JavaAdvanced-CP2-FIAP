package com.fiap.cp2.entities;

import com.fiap.cp2.exceptions.ValidacaoDominioException;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Author {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String email;

    public Author(String name, String email) {
        setNome(name);
        setEmail(email);
    }

    public Author() {

    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public void setId(Long id) {
        this.id = id;
        isIdValido();
    }

    private void isIdValido() {
        if (id == null) {
            throw new ValidacaoDominioException("Id nulo");
        }
    }

    public void setNome(String nome) {
        this.nome = nome;
        isNomeValido();
    }

    private void isNomeValido() {
        //valida se nome é nulo, vazio ou em branco
        if (nome == null || nome.isEmpty()) {
            throw new ValidacaoDominioException("Nome vazio");
        }

        //valida se a palavra tem no minimo 3 caracteres
        if(nome.length() < 3){
            throw new ValidacaoDominioException("Nome deve ter pelo menos 3 caracteres");
        }
    }

    public void setEmail(String email) {
        this.email = email;
        isEmailValido();
    }

    private void isEmailValido() {
        final String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        if (!email.matches(regex)) {
            throw new ValidacaoDominioException("Email inválido");
        }
    }
}
