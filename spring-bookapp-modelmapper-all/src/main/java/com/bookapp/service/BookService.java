package com.bookapp.service;

import com.bookapp.dto.BookRequestDTO;
import com.bookapp.dto.BookResponseDTO;

import java.util.List;

public interface BookService {

    void addBook(BookRequestDTO requestDTO);

    void updateBook(BookRequestDTO requestDTO);

    void deleteBook(int bookId);

    BookResponseDTO getById(int bookId);

    List<BookResponseDTO> getAll();

    List<BookResponseDTO> getByAuthor(String authorName);
}
