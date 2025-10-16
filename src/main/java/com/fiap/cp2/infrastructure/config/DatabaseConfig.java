package com.fiap.cp2.infrastructure.config;

import com.fiap.cp2.domain.repository.AuthorRepository;
import com.fiap.cp2.infrastructure.persistance.AuthorRepositoryAdapter;
import com.fiap.cp2.infrastructure.repository.JpaAuthorRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseConfig {

    @Bean
    public AuthorRepository authorRepository(JpaAuthorRepository jpaAuthorRepository) {
        return new AuthorRepositoryAdapter(jpaAuthorRepository);
    }

}
