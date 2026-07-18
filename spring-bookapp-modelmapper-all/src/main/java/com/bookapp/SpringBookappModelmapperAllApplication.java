package com.bookapp;

import com.bookapp.dto.*;
import com.bookapp.model.Book;
import com.bookapp.service.AuthorService;
import com.bookapp.service.BookService;
import com.bookapp.service.CategoryService;
import com.bookapp.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class SpringBookappModelmapperAllApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringBookappModelmapperAllApplication.class, args);
	}

    @Autowired
    private AuthorService authorService;

    @Autowired
    private BookService bookService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private PublisherService publisherService;

    @Override
    public void run(String... args) throws Exception {
        AuthorRequestDTO author1 = new AuthorRequestDTO(
                "Joshua Bloch",
                "USA"
        );
        authorService.addAuthor(author1);

        AuthorRequestDTO author2 = new AuthorRequestDTO(
                "Herbert Schildt",
                "USA"
        );
        authorService.addAuthor(author2);

        CategoryRequestDTO category1 = new CategoryRequestDTO(
                "Programming",null
        );
        categoryService.addCategory(category1);

        CategoryRequestDTO category2 = new CategoryRequestDTO(
                "Java", null
        );
        categoryService.addCategory(category2);


        PublisherRequestDTO publisher1 = new PublisherRequestDTO(
                "Tech Publications",
                "Pune, India",
                null
        );
        publisherService.addPublisher(publisher1);

        PublisherRequestDTO publisher2 = new PublisherRequestDTO(
                "Code World Publications",
                "Mumbai, India",
                null
        );
        publisherService.addPublisher(publisher2);

        // One to One
        BookDetailRequestDTO bookDetailRequestDTO = new BookDetailRequestDTO("English", 100, 2025);

        // One to Many
        ReviewRequestDTO reviewRequestDTO1 = new ReviewRequestDTO(
                "Rakesh",
                "Good",
                3
        );

        ReviewRequestDTO reviewRequestDTO2 = new ReviewRequestDTO(
                "Priya",
                "Excellent book with clear explanations.",
                5
        );

        ReviewRequestDTO reviewRequestDTO3 = new ReviewRequestDTO(
                "Rahul",
                "Informative but could include more practical examples.",
                4
        );

        List<ReviewRequestDTO> reviewRequestDTOList = Arrays.asList(reviewRequestDTO1, reviewRequestDTO2, reviewRequestDTO3);

        //Many to One
        PublisherRequestDTO publisherRequestDTO = publisherService.getById(1);
        AuthorRequestDTO authorRequestDTO = authorService.getById(1);

        // Many to Many
        CategoryRequestDTO categoryReq1 = categoryService.getById(1);
        CategoryRequestDTO  categoryReq2 = categoryService.getById(2);

        List<CategoryRequestDTO> categoryRequestDTOList = Arrays.asList(categoryReq1, categoryReq2);

        BookRequestDTO bookRequestDTO =
                new BookRequestDTO(
                        "Atomic Habit",
                        900,
                        bookDetailRequestDTO,
                        publisherRequestDTO,
                        authorRequestDTO,
                        reviewRequestDTOList,
                        categoryRequestDTOList
                );
                bookService.addBook(bookRequestDTO);







    }
}
