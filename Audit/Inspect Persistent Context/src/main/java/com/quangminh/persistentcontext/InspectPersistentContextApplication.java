package com.quangminh.persistentcontext;

import com.quangminh.persistentcontext.service.BookstoreService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InspectPersistentContextApplication {


    private final BookstoreService bookstoreService;

    public InspectPersistentContextApplication(BookstoreService bookstoreService) {
        this.bookstoreService = bookstoreService;
    }

    public static void main(String[] args) {
        SpringApplication.run(InspectPersistentContextApplication.class, args);
    }

    @Bean
    public ApplicationRunner init() {
        return args -> {
            bookstoreService.sqlOperations();
        };
    }
}
