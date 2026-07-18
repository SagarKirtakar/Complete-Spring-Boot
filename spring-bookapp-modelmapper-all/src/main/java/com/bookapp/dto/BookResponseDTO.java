package com.bookapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookResponseDTO {

    private Integer bookId;

    private String title;

    private String isbn;

    private double price;

    private BookDetailRequestDTO bookDetail;

    private PublisherRequestDTO publisher;

    private AuthorRequestDTO author;

    private List<ReviewRequestDTO> reviewRequestDTOS;

    private List<CategoryRequestDTO> categories;

}