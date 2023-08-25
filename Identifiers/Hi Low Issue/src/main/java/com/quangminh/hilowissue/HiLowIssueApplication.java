package com.quangminh.hilowissue;

import com.quangminh.hilowissue.service.BookstoreService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HiLowIssueApplication {


    private final BookstoreService bookstoreService;

    public HiLowIssueApplication(BookstoreService bookstoreService) {
        this.bookstoreService = bookstoreService;
    }

    public static void main(String[] args) {
        SpringApplication.run(HiLowIssueApplication.class, args);
    }

    @Bean
    public ApplicationRunner init() {
        return args -> {
            bookstoreService.save3Authors();
//            bookstoreService.saveAuthorNative();
        };
    }
}
