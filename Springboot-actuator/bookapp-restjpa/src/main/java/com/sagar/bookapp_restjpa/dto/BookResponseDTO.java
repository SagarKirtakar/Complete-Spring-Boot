package com.sagar.bookapp_restjpa.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookResponseDTO {

    private Long bookId;
    private String title;
    private String author;
    private Double price;
}
