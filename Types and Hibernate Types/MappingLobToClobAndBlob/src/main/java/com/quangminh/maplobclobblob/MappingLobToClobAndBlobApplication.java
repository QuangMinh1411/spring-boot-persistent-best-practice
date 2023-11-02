package com.quangminh.maplobclobblob;

import com.quangminh.maplobclobblob.service.BookstoreService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MappingLobToClobAndBlobApplication {


    private final BookstoreService bookstoreService;

    public MappingLobToClobAndBlobApplication(BookstoreService bookstoreService) {
        this.bookstoreService = bookstoreService;
    }
    public static void main(String[] args) {
        SpringApplication.run(MappingLobToClobAndBlobApplication.class, args);
    }
    @Bean
    public ApplicationRunner init() {
        return args -> {
            bookstoreService.newAuthor();
            bookstoreService.fetchAuthor();
        };
    }
}
