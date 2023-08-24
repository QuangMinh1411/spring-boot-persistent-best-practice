package com.quangminh.transactionaltimeout;

import com.quangminh.transactionaltimeout.service.BookstoreService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TransactionalTimeOutApplication {


    private final BookstoreService bookstoreService;

    public TransactionalTimeOutApplication(BookstoreService bookstoreService) {
        this.bookstoreService = bookstoreService;
    }

    public static void main(String[] args) {
        SpringApplication.run(TransactionalTimeOutApplication.class, args);
    }

    @Bean
    public ApplicationRunner init() {
        return args -> {
            bookstoreService.newAuthor();
        };
    }
}
