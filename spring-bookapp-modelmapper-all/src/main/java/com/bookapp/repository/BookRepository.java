package com.bookapp.repository;

import com.bookapp.dto.BookResponseDTO;
import com.bookapp.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    Book getById(int bookId);

    List<Book> getByAuthor(String authorName);
}
