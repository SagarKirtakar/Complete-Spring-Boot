package com.bookapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class BookDetail {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer detail_id;

    private String lang;

    private int pages;

    private int yearPublished;

}
