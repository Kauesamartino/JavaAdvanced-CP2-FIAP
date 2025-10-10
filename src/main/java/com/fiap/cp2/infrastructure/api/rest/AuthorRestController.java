package com.fiap.cp2.infrastructure.api.rest;

import com.fiap.cp2.interfaces.dto.AuthorInDto;
import com.fiap.cp2.interfaces.dto.AuthorOutDto;
import com.fiap.cp2.interfaces.dto.AuthorResumeOutDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.fiap.cp2.interfaces.controller.AuthorController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

/**
 * Adaptador REST para o controller de Author
 * Esta classe contém as anotações específicas do springframework e
 * delega as chamadas para o controller puro.
 */
@RestController
@RequestMapping("/authors")
public class AuthorRestController {


    private final AuthorController authorController;

    public AuthorRestController(AuthorController authorController) {
        this.authorController = authorController;
    }

    @PostMapping
    public ResponseEntity<AuthorOutDto> createAuthor(@RequestBody AuthorInDto authorInDto, UriComponentsBuilder uriComponentsBuilder){
        final AuthorOutDto dto = authorController.createAuthor(authorInDto);
        URI uri = uriComponentsBuilder.path("/authors/{id}").buildAndExpand(dto.id()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @GetMapping
    public ResponseEntity<List<AuthorResumeOutDto>> listAuthors(){
        final List<AuthorResumeOutDto> authorsPage = authorController.listAuthors();
        return ResponseEntity.ok(authorsPage);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorOutDto> getAuthorById(@PathVariable Long id){
        final AuthorOutDto dto = authorController.getAuthorById(id);
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/{id}")
    public  ResponseEntity<AuthorOutDto> updateAuthor(@RequestBody AuthorInDto authorInDto){
        final AuthorOutDto dto = authorController.updateAuthor(authorInDto);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable Long id) {
        authorController.deleteAuthor(id);
        return ResponseEntity.noContent().build();
    }
}
