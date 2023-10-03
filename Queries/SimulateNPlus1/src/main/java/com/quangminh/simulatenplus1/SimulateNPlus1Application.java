package com.quangminh.simulatenplus1;

import com.quangminh.simulatenplus1.service.BookstoreService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SimulateNPlus1Application {


    private final BookstoreService bookstoreService;

    public SimulateNPlus1Application(BookstoreService bookstoreService) {
        this.bookstoreService = bookstoreService;
    }

    public static void main(String[] args) {
        SpringApplication.run(SimulateNPlus1Application.class, args);
    }

    @Bean
    public ApplicationRunner init() {
        return args -> {
            System.out.println("\nFetch all books and authors  ...");
            bookstoreService.fetchBooksAndAuthors();

            System.out.println("\nFetch all authors and books  ...");
            bookstoreService.fetchAuthorsAndBooks();
        };
    }
}
