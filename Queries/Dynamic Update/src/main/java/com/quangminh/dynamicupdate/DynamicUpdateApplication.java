package com.quangminh.dynamicupdate;

import com.quangminh.dynamicupdate.entity.Author;
import com.quangminh.dynamicupdate.service.BookstoreService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DynamicUpdateApplication {


    private final BookstoreService bookstoreService;

    public DynamicUpdateApplication(BookstoreService bookstoreService) {
        this.bookstoreService = bookstoreService;
    }

    public static void main(String[] args) {
        SpringApplication.run(DynamicUpdateApplication.class, args);
    }

    @Bean
    public ApplicationRunner init() {
        return args -> {

            System.out.println("Update attached entity:");
            bookstoreService.updateAuthor();

            System.out.println();

            System.out.println("Update detached entity:");
            Author author = bookstoreService.fetchAuthor();
            bookstoreService.updateDetachedAuthor(author);
        };
    }
}
