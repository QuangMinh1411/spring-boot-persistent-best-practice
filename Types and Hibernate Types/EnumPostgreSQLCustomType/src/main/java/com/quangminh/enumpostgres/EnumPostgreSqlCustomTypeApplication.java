package com.quangminh.enumpostgres;

import com.quangminh.enumpostgres.service.BookstoreService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EnumPostgreSqlCustomTypeApplication {


    private final BookstoreService bookstoreService;

    public EnumPostgreSqlCustomTypeApplication(BookstoreService bookstoreService) {
        this.bookstoreService = bookstoreService;
    }

    public static void main(String[] args) {
        SpringApplication.run(EnumPostgreSqlCustomTypeApplication.class, args);
    }
    @Bean
    public ApplicationRunner init() {
        return args -> {
            bookstoreService.persistNewAuthor();
            bookstoreService.fetchAuthor();
        };
    }
}
