package com.fiap.cp2.services;

import com.fiap.cp2.entities.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookService {
    Page<Book> findAll(Pageable pageable);

    Book findById(Long id);

    Book saveOrUpdate(Book book);

    void deleteById(Long id);
}
