package com.bookapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookRequestDTO {

    private String title;

    private double price;

    private BookDetailRequestDTO bookDetail;

    private PublisherRequestDTO publisher;

    private AuthorRequestDTO author;

    private List<ReviewRequestDTO> reviews;

    private List<CategoryRequestDTO> categories;

}