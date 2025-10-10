package com.fiap.cp2.infrastructure.repository;

import com.fiap.cp2.infrastructure.entity.JpaBookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaBookRepository extends JpaRepository<JpaBookEntity, Long> {
}
