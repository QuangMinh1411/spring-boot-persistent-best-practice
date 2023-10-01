package com.quangminh.entitylistener;

import com.quangminh.entitylistener.service.BookstoreService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EntityListenerApplication {


    private final BookstoreService bookstoreService;

    public EntityListenerApplication(BookstoreService bookstoreService) {
        this.bookstoreService = bookstoreService;
    }

    public static void main(String[] args) {
        SpringApplication.run(EntityListenerApplication.class, args);
    }

    @Bean
    public ApplicationRunner init() {
        return args -> {
            System.out.println("\n\npersistAuthorWithBooks():");
            bookstoreService.persistAuthorWithBooks();

            System.out.println("\n\nfetchAndRemovePaperback():");
            bookstoreService.fetchAndRemovePaperback();

            System.out.println("\n\nfetchAndRemoveEbook():");
            bookstoreService.fetchAndRemoveEbook();
        };
    }
}
