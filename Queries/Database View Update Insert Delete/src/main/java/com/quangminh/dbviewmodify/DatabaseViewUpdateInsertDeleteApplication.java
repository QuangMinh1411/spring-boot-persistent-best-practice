package com.quangminh.dbviewmodify;

import com.quangminh.dbviewmodify.service.BookstoreService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DatabaseViewUpdateInsertDeleteApplication {


    private final BookstoreService bookstoreService;

    public DatabaseViewUpdateInsertDeleteApplication(BookstoreService bookstoreService) {
        this.bookstoreService = bookstoreService;
    }

    public static void main(String[] args) {
        SpringApplication.run(DatabaseViewUpdateInsertDeleteApplication.class, args);
    }

    @Bean
    public ApplicationRunner init() {
        return args -> {
            bookstoreService.updateAuthorAgeViaView();
            bookstoreService.insertAuthorViaView();
            bookstoreService.deleteAuthorViaView();
        };
    }
}
