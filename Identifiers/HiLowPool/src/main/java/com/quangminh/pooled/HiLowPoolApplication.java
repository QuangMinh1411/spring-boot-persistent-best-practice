package com.quangminh.pooled;

import com.quangminh.pooled.service.BookstoreService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HiLowPoolApplication {


    private final BookstoreService bookstoreService;

    public HiLowPoolApplication(BookstoreService bookstoreService) {
        this.bookstoreService = bookstoreService;
    }

    public static void main(String[] args) {
        SpringApplication.run(HiLowPoolApplication.class, args);
    }

    @Bean
    public ApplicationRunner init() {
        return args -> {
            bookstoreService.save3Authors();
            bookstoreService.saveAuthorNative();
        };
    }
}
