package com.fiap.cp2.controllers;

import com.fiap.cp2.dto.AuthorInDto;
import com.fiap.cp2.dto.AuthorOutDto;
import com.fiap.cp2.entities.Author;
import com.fiap.cp2.mappers.AuthorMapper;
import com.fiap.cp2.services.AuthorService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public ResponseEntity<Page<AuthorOutDto>> findAll(@RequestParam(required = false, defaultValue = "0") Integer page,
                                                      @RequestParam(required = false, defaultValue = "10") Integer size) {
        final Page<Author> authors = this.authorService.findAll(PageRequest.of(page, size));
        final List<AuthorOutDto> dto = authors.stream()
                .map(AuthorMapper::toOutDto).toList();
        return ResponseEntity.ok(new PageImpl<>(dto, authors.getPageable(), authors.getTotalElements()));
    }

    @PostMapping
    public ResponseEntity<AuthorOutDto> create(@Validated @RequestBody AuthorInDto authorInDto) {
        final Author author = this.authorService.saveOrUpdate(AuthorMapper.toEntity(authorInDto));
        return ResponseEntity.ok(AuthorMapper.toOutDto(author));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorOutDto> findById(@PathVariable Long id) {
        final Author author = this.authorService.findById(id);
        return ResponseEntity.ok(AuthorMapper.toOutDto(author));
    }
}
