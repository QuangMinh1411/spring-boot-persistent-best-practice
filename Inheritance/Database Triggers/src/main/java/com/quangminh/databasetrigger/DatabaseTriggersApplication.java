package com.quangminh.databasetrigger;

import com.quangminh.databasetrigger.service.BookstoreService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DatabaseTriggersApplication {


    private final BookstoreService bookstoreService;

    public DatabaseTriggersApplication(BookstoreService bookstoreService) {
        this.bookstoreService = bookstoreService;
    }

    public static void main(String[] args) {
        SpringApplication.run(DatabaseTriggersApplication.class, args);
    }

    @Bean
    public ApplicationRunner init() {
        return args -> {
            // this will successfully pass the `check_book_pages` trigger check
            bookstoreService.addNewChapterSuccess();

            // this will cause database trigger `check_book_pages` to fail
            bookstoreService.addNewChapterFail();
        };
    }
}
