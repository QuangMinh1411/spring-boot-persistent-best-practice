package com.quangminh.transactionalrepository;

import com.quangminh.transactionalrepository.service.BookstoreService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TransactionalInRepositoryApplication {


    private final BookstoreService bookstoreService;

    public TransactionalInRepositoryApplication(BookstoreService bookstoreService) {
        this.bookstoreService = bookstoreService;
    }

    public static void main(String[] args) {
        SpringApplication.run(TransactionalInRepositoryApplication.class, args);
    }

    @Bean
    public ApplicationRunner init() {
        return args -> {
            bookstoreService.newAuthors();
            System.out.println("=========================================");
            System.out.println("=========================================");
            System.out.println("=========================================");
            bookstoreService.longRunningServiceMethod();
            System.out.println("=========================================");
        };
    }
}
