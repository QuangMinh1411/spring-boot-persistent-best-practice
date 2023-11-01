package com.quangminh.mappedsuperclass;

import com.quangminh.mappedsuperclass.service.BookstoreService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MappedSuperclassApplication {


    private final BookstoreService bookstoreService;

    public MappedSuperclassApplication(BookstoreService bookstoreService) {
        this.bookstoreService = bookstoreService;
    }

    public static void main(String[] args) {
        SpringApplication.run(MappedSuperclassApplication.class, args);
    }
    @Bean
    public ApplicationRunner init() {
        return args -> {
            System.out.println("\n\npersistAuthorWithBooks():");
            bookstoreService.persistAuthorWithBooks();

            System.out.println("\n\nfetchPaperback():");
            bookstoreService.fetchPaperback();
            System.out.println("\n\nfetchEbook():");
            bookstoreService.fetchEbook();

            System.out.println("\n\nfetchEbookByAuthorId():");
            bookstoreService.fetchEbookByAuthorId();

            System.out.println("\n\nfetchPaperbackByAuthorId():");
            bookstoreService.fetchPaperbackByAuthorId();
        };
    }
}
