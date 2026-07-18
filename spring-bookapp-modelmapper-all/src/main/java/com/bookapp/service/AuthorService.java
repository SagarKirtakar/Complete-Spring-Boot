package com.bookapp.service;

import com.bookapp.dto.AuthorRequestDTO;

public interface AuthorService {

    void addAuthor(AuthorRequestDTO requestDTO);

    void updateAuthor(AuthorRequestDTO requestDTO);

    void deleteById(int authorId);

    AuthorRequestDTO getById(int authorId);
}
