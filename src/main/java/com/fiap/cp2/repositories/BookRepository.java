package com.fiap.cp2.repositories;

import com.fiap.cp2.entities.Author;
import com.fiap.cp2.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findBooksByAuthorId(Long id);

}
