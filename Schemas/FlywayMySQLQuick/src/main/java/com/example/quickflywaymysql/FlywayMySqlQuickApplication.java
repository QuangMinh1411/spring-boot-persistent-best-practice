package com.example.quickflywaymysql;

import com.example.quickflywaymysql.service.BookstoreService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FlywayMySqlQuickApplication {


    private final BookstoreService bookstoreService;

    public FlywayMySqlQuickApplication(BookstoreService bookstoreService) {
        this.bookstoreService = bookstoreService;
    }

    public static void main(String[] args) {
        SpringApplication.run(FlywayMySqlQuickApplication.class, args);
    }

    @Bean
    public ApplicationRunner init() {
        return args -> {

            System.out.println("\nAdd author with books  ...");
            bookstoreService.addAuthorWithBooks();

            System.out.println("\nRemove a book of an author...");
            bookstoreService.removeBookOfAuthor();

            System.out.println("\nRemove all book of an author...");
            bookstoreService.removeAllBooksOfAuthor();
        };
    }
}
