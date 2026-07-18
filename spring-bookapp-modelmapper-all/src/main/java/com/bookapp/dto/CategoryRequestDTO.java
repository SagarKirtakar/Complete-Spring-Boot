package com.bookapp.dto;

import com.bookapp.model.Book;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "books")
public class CategoryRequestDTO {

    private String category_name;

    private List<Book> books;

}