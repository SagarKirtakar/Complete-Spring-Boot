package com.sagar.bookapp_restjpa.service;

import com.sagar.bookapp_restjpa.dto.BookResponseDTO;
import com.sagar.bookapp_restjpa.exception.BookNotFoundException;
import com.sagar.bookapp_restjpa.model.Book;
import com.sagar.bookapp_restjpa.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository repository;

    @Override
    public BookResponseDTO createBook(BookResponseDTO dto) {

        Book book = Book.builder()
                .title(dto.getTitle())
                .author(dto.getAuthor())
                .price(dto.getPrice())
                .build();

        Book saved = repository.save(book);

        return mapToDTO(saved);
    }

    @Override
    public List<BookResponseDTO> getAllBooks() {

        return repository.findAll()
                .stream()
                .map(this::mapToDTO)
                .toList();
    }

    @Override
    public BookResponseDTO getBookById(Long id) {

        Book book = repository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));

        return mapToDTO(book);
    }

    @Override
    public BookResponseDTO updateBook(Long id, BookResponseDTO dto) {

        Book book = repository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));

        book.setTitle(dto.getTitle());
        book.setAuthor(dto.getAuthor());
        book.setPrice(dto.getPrice());

        return mapToDTO(repository.save(book));
    }

    @Override
    public void deleteBook(Long id) {

        Book book = repository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));

        repository.delete(book);
    }

    private BookResponseDTO mapToDTO(Book book) {

        return BookResponseDTO.builder()
                .bookId(book.getBookId())
                .title(book.getTitle())
                .author(book.getAuthor())
                .price(book.getPrice())
                .build();
    }
}