package com.bookapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString(exclude = "books")
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer publisher_id;
    private String name;
    private String address;

    @OneToMany(mappedBy = "publisher")
    private List<Book> books;
}
