package com.fiap.cp2.controllers;

import com.fiap.cp2.dto.BookOutDto;
import com.fiap.cp2.entities.Book;
import com.fiap.cp2.mappers.BookMapper;
import com.fiap.cp2.services.BookService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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


}
