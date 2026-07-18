package com.bookapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDetailRequestDTO {

    private String lang;

    private int pages;

    private int yearPublished;

}