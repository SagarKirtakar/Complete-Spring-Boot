package com.bookapp.repository;

import com.bookapp.dto.AuthorRequestDTO;
import com.bookapp.dto.BookResponseDTO;
import com.bookapp.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

    AuthorRequestDTO getById(int authorId);
    void deleteById(int authorId);

}
