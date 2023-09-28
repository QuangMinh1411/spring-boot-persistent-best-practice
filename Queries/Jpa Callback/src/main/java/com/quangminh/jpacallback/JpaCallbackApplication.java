package com.quangminh.jpacallback;

import com.quangminh.jpacallback.service.BookstoreService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpaCallbackApplication {


    private final BookstoreService bookstoreService;

    public JpaCallbackApplication(BookstoreService bookstoreService) {
        this.bookstoreService = bookstoreService;
    }

    public static void main(String[] args) {
        SpringApplication.run(JpaCallbackApplication.class, args);
    }

    @Bean
    ApplicationRunner init() {
        return args -> {

            bookstoreService.newAuthor();
            bookstoreService.selectUpdateDeleteAuthor();
        };
    }
}
