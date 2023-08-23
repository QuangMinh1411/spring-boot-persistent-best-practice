package com.quangminh.transactionalreadonly;

import com.quangminh.transactionalreadonly.service.BookstoreService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TransactionalReadOnlyMeaningApplication {
    private final BookstoreService bookstoreService;

    public TransactionalReadOnlyMeaningApplication(BookstoreService bookstoreService) {
        this.bookstoreService = bookstoreService;
    }


    public static void main(String[] args) {
        SpringApplication.run(TransactionalReadOnlyMeaningApplication.class, args);
    }

    @Bean
    public ApplicationRunner init() {
        return args -> {

            System.out.println("\n\nREAD-WRITE MODE:");
            bookstoreService.fetchAuthorReadWriteMode();

            System.out.println("\n\nREAD-ONLY MODE:");
            bookstoreService.fetchAuthorReadOnlyMode();

            System.out.println("\n\nREAD-WRITE MODE (DTO):");
            bookstoreService.fetchAuthorDtoReadWriteMode();

            System.out.println("\n\nREAD-ONLY MODE (DTO):");
            bookstoreService.fetchAuthorDtoReadOnlyMode();
        };
    }
}
