package com.fiap.cp2.repositories;

import com.fiap.cp2.entities.Author;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    Page<Author> findALl(Pageable pageable);

}
