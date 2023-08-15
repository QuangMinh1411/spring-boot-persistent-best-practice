package com.quangminh.bulkupdate;

import com.quangminh.bulkupdate.service.BookstoreService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BulkUpdateApplication {

    private final BookstoreService bookstoreService;

    public BulkUpdateApplication(BookstoreService bookstoreService) {
        this.bookstoreService = bookstoreService;
    }

    public static void main(String[] args) {
        SpringApplication.run(BulkUpdateApplication.class, args);
    }

    @Bean
    public ApplicationRunner init() {
        return args -> {

            bookstoreService.persistAuthorsAndBooks();

//             bookstoreService.updateAuthorsAndBooks();
            bookstoreService.updateAuthorsGtAgeAndBooks();
        };
    }
}
