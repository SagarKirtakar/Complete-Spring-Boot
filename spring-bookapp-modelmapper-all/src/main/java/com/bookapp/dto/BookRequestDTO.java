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

    private String isbn;

    private double price;

    private BookDetailRequestDTO bookDetail;

    private List<ReviewRequestDTO> reviews;

    private Integer publisherId;

    private Integer authorId;

    private List<Integer> categoryIds;
}