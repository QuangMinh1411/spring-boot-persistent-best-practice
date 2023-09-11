package com.quangminh.logbinding;

import com.quangminh.logbinding.service.BookstoreService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LogBindingMySqlParameterApplication {

    private final BookstoreService bookstoreService;

    public LogBindingMySqlParameterApplication(BookstoreService bookstoreService) {
        this.bookstoreService = bookstoreService;
    }

    public static void main(String[] args) {
        SpringApplication.run(LogBindingMySqlParameterApplication.class, args);
    }

    @Bean
    public ApplicationRunner init() {
        return args -> {

            bookstoreService.persistAuthor();
            bookstoreService.displayAuthor();
        };
    }
}
