package com.sagar.bookapp_restjpa.controller;

import com.sagar.bookapp_restjpa.dto.BookResponseDTO;
import com.sagar.bookapp_restjpa.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookResponseDTO createBook(@RequestBody BookResponseDTO dto) {
        return service.createBook(dto);
    }

    @GetMapping
    public List<BookResponseDTO> getAllBooks() {
        return service.getAllBooks();
    }

    @GetMapping("/{id}")
    public BookResponseDTO getBookById(@PathVariable Long id) {
        return service.getBookById(id);
    }

    @PutMapping("/{id}")
    public BookResponseDTO updateBook(@PathVariable Long id,
                                      @RequestBody BookResponseDTO dto) {
        return service.updateBook(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<String> deleteBook(@PathVariable Long id) {
        service.deleteBook(id);
        return ResponseEntity.ok("Book deleted successfully");
    }
}