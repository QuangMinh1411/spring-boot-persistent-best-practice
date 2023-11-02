package com.quangminh.lobtostring;

import com.quangminh.lobtostring.service.BookstoreService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MappingLobToByteStringApplication {


    private final BookstoreService bookstoreService;

    public MappingLobToByteStringApplication(BookstoreService bookstoreService) {
        this.bookstoreService = bookstoreService;
    }

    public static void main(String[] args) {
        SpringApplication.run(MappingLobToByteStringApplication.class, args);
    }
    @Bean
    public ApplicationRunner init() {
        return args -> {
            bookstoreService.newAuthor();
            bookstoreService.fetchAuthor();
        };
    }
}
