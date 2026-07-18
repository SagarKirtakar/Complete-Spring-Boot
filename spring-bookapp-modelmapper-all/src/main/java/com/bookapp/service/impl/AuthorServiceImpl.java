package com.bookapp.service.impl;

import com.bookapp.dto.AuthorRequestDTO;
import com.bookapp.model.Author;
import com.bookapp.repository.AuthorRepository;
import com.bookapp.service.AuthorService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final ModelMapper modelMapper;

    @Override
    public void addAuthor(AuthorRequestDTO requestDTO) {
        Author author = modelMapper.map(requestDTO, Author.class);
        authorRepository.save(author);
    }

    @Override
    public void updateAuthor(AuthorRequestDTO requestDTO) {
        Author author = modelMapper.map(requestDTO, Author.class);
        authorRepository.save(author);
    }

    @Override
    public void deleteById(int authorId) {
    authorRepository.deleteById(authorId);
    }

    @Override
    public AuthorRequestDTO getById(int authorId) {
        Author author = authorRepository.findById(authorId).get();
        return modelMapper.map(author, AuthorRequestDTO.class);
    }
}
