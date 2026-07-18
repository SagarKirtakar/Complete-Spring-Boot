package com.bookapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookId;

    private String title;

    private String isbn;

    private double price;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bookdetail_Id")
    private BookDetail bookDetail;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Review> reviews;

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    @ManyToMany
    @JoinTable(name = "book_category",
    joinColumns =
            @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private List<Category> categories = new ArrayList<>();

}

