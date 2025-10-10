package com.fiap.cp2.infrastructure.repository;

import com.fiap.cp2.infrastructure.entity.JpaAuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaAuthorRepository extends JpaRepository<JpaAuthorEntity, Long> {
}
