package com.quangminh.flywaytwovendors;

import com.quangminh.flywaytwovendors.ds1.AuthorService;
import com.quangminh.flywaytwovendors.ds2.BookService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FlywayTwoVendorsApplication {


    private final AuthorService authorService;
    private final BookService bookService;

    public FlywayTwoVendorsApplication(AuthorService authorService, BookService bookService) {
        this.authorService = authorService;
        this.bookService = bookService;
    }

    public static void main(String[] args) {
        SpringApplication.run(FlywayTwoVendorsApplication.class, args);
    }

    @Bean
    public ApplicationRunner init() {
        return args -> {

            System.out.println("\n Saving an author (check the MySQL database) ...");
            authorService.persistAuthor();

            System.out.println("\n Saving a book (check the PostgreSQL database) ...");
            bookService.persistBook();
        };
    }
}
