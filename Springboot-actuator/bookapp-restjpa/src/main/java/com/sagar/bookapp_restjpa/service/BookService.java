package com.sagar.bookapp_restjpa.service;

import com.sagar.bookapp_restjpa.dto.BookResponseDTO;

import java.util.List;

public interface BookService {

    BookResponseDTO createBook(BookResponseDTO dto);

    List<BookResponseDTO> getAllBooks();

    BookResponseDTO getBookById(Long id);

    BookResponseDTO updateBook(Long id, BookResponseDTO dto);

    void deleteBook(Long id);
}