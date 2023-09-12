package com.example.twodatasource;

import com.example.twodatasource.ds1.AuthorService;
import com.example.twodatasource.ds2.BookService;
import com.example.twodatasource.service.AuthorBookService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TwoDatasourceBuilderKickoffApplication {

    private final BookService bookService;
    private final AuthorBookService authorBookService;

    private final AuthorService authorService;

    public TwoDatasourceBuilderKickoffApplication(BookService bookService, AuthorBookService authorBookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorBookService = authorBookService;
        this.authorService = authorService;
    }

    public static void main(String[] args) {
        SpringApplication.run(TwoDatasourceBuilderKickoffApplication.class, args);
    }

    @Bean
    public ApplicationRunner init() {
        return args -> {
            System.out.println("\n Saving authors (check the 'authorsdb' database) ...");
            authorService.persistAuthor();
            authorBookService.persistAuthor();

            System.out.println("\n Saving books (check the 'booksdb' database) ...");
            bookService.persistBook();
            authorBookService.persistBook();
        };
    }

}
