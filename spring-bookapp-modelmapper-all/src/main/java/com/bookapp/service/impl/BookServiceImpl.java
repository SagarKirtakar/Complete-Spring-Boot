package com.bookapp.service.impl;

import com.bookapp.dto.BookRequestDTO;
import com.bookapp.dto.BookResponseDTO;
import com.bookapp.model.Book;
import com.bookapp.repository.BookRepository;
import com.bookapp.service.BookService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final ModelMapper modelMapper;

    @Override
    public void addBook(BookRequestDTO requestDTO) {
        Book book = modelMapper.map(requestDTO, Book.class);
        book.setIsbn(generateIsbn());
        bookRepository.save(book);
    }

    @Override
    public void updateBook(BookRequestDTO requestDTO) {
        Book book = modelMapper.map(requestDTO, Book.class);
        bookRepository.save(book);
    }

    @Override
    public void deleteBook(int bookId) {
    bookRepository.deleteById(bookId);
    }

    @Override
    public BookResponseDTO getById(int bookId) {
       Book book =  bookRepository.getById(bookId);
       return modelMapper.map(book, BookResponseDTO.class);
    }

    @Override
    public List<BookResponseDTO> getAll() {
        List<Book> books = bookRepository.findAll();
        List<BookResponseDTO> responseDTOS = books.stream()
                .map(book -> modelMapper.map(book, BookResponseDTO.class))
                .toList();
        return responseDTOS;
    }

    @Override
    public List<BookResponseDTO> getByAuthor(String authorName) {
        List<Book> books = bookRepository.getByAuthor(authorName);
        List<BookResponseDTO> dtoList = books.stream()
                .map(book -> modelMapper.map(book, BookResponseDTO.class))
                .toList();

        return dtoList;
    }

    public String generateIsbn() {
        return "ISBN"+ UUID.randomUUID().toString().substring(0, 13);
    }
}
