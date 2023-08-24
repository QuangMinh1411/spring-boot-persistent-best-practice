package com.quangminh.transactionalid;

import com.quangminh.transactionalid.service.BookstoreService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TransactionalIdApplication {
    private final BookstoreService bookstoreService;

    public TransactionalIdApplication(BookstoreService bookstoreService) {
        this.bookstoreService = bookstoreService;
    }

    public static void main(String[] args) {
        SpringApplication.run(TransactionalIdApplication.class, args);
    }

    @Bean
    public ApplicationRunner init() {
        return args -> {
            bookstoreService.displayTransactionId();
        };
    }
}
