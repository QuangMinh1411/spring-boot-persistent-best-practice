package com.quangminh.p6spy;

import com.quangminh.p6spy.service.BookstoreService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class P6spyApplication {

    private final BookstoreService bookstoreService;

    public P6spyApplication(BookstoreService bookstoreService) {
        this.bookstoreService = bookstoreService;
    }

    public static void main(String[] args) {
        SpringApplication.run(P6spyApplication.class, args);
    }

    @Bean
    public ApplicationRunner init() {
        return args -> {

            bookstoreService.persistAuthor();
            bookstoreService.displayAuthor();
        };
    }
}
