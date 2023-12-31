package com.quangminh.autogenerate;

import com.quangminh.autogenerate.service.BookstoreService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AutoGenerateTypeApplication {


    private final BookstoreService bookstoreService;

    public AutoGenerateTypeApplication(BookstoreService bookstoreService) {
        this.bookstoreService = bookstoreService;
    }

    public static void main(String[] args) {
        SpringApplication.run(AutoGenerateTypeApplication.class, args);
    }

    @Bean
    public ApplicationRunner init() {
        return args -> {

            System.out.println("Persist good author ...");
            bookstoreService.persistGoodAuthor();

            System.out.println("\nPersist bad author ...");
            bookstoreService.persistBadAuthor();
        };
    }
}
