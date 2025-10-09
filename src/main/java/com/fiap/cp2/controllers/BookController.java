package com.fiap.cp2.controllers;

import com.fiap.cp2.dto.BookInDto;
import com.fiap.cp2.dto.BookOutDto;
import com.fiap.cp2.entities.Book;
import com.fiap.cp2.mappers.BookMapper;
import com.fiap.cp2.services.BookService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<Page<BookOutDto>> findAll(@RequestParam(required = false, defaultValue = "0") Integer page,
                                                    @RequestParam(required = false, defaultValue = "10") Integer size) {

        final Page<Book> books = this.bookService.findAll(PageRequest.of(page, size));
        final List<BookOutDto> dto = books.stream()
                .map(BookMapper::toOutDto).toList();
        return ResponseEntity.ok(new PageImpl<>(dto, books.getPageable(), books.getTotalElements()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookOutDto> findById(@PathVariable Long id) {
        final Book book = this.bookService.findById(id);
        return ResponseEntity.ok(BookMapper.toOutDto(book));
    }

    @PostMapping
    public ResponseEntity<BookOutDto> createBook(@RequestBody BookInDto book) {
        final Book savedBook = this.bookService.saveOrUpdate(BookMapper.toEntity(book));
        return ResponseEntity.ok(BookMapper.toOutDto(savedBook));
    }

    @PutMapping
    public ResponseEntity<BookOutDto> createBook(@RequestBody BookInDto book) {
        final Book savedBook = this.bookService.saveOrUpdate(BookMapper.toEntity(book));
        return ResponseEntity.ok(BookMapper.toOutDto(savedBook));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        this.bookService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
