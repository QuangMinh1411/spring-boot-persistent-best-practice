package com.quangminh.transactionalignored;

import com.quangminh.transactionalignored.service.BookstoreService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WhyTransactionalIsIgnoredApplication {


    private final BookstoreService bookstoreService;

    public WhyTransactionalIsIgnoredApplication(BookstoreService bookstoreService) {
        this.bookstoreService = bookstoreService;
    }

    public static void main(String[] args) {
        SpringApplication.run(WhyTransactionalIsIgnoredApplication.class, args);
    }

    @Bean
    public ApplicationRunner init() {
        return args -> {
            bookstoreService.mainAuthor();
        };
    }
}
