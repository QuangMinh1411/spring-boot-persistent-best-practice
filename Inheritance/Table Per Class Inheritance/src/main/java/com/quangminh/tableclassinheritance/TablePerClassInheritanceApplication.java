package com.quangminh.tableclassinheritance;

import com.quangminh.tableclassinheritance.service.BookstoreService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TablePerClassInheritanceApplication {

    private final BookstoreService bookstoreService;

    public TablePerClassInheritanceApplication(BookstoreService bookstoreService) {
        this.bookstoreService = bookstoreService;
    }

    public static void main(String[] args) {
        SpringApplication.run(TablePerClassInheritanceApplication.class, args);
    }
    @Bean
    public ApplicationRunner init() {
        return args -> {
            System.out.println("\n\npersistAuthorWithBooks():");
            bookstoreService.persistAuthorWithBooks();

            System.out.println("\n\nfetchBookByTitle():");
            bookstoreService.fetchBookByTitle();

            System.out.println("\n\nfetchPaperback():");
            bookstoreService.fetchPaperback();
            System.out.println("\n\nfetchEbook():");
            bookstoreService.fetchEbook();

            System.out.println("\n\nfetchBooksByAuthorId():");
            bookstoreService.fetchBooksByAuthorId();
            System.out.println("\n\nfetchAuthorAndBooksLazy():");
            bookstoreService.fetchAuthorAndBooksLazy();
            System.out.println("\n\nfetchAuthorAndBooksEager():");
            bookstoreService.fetchAuthorAndBooksEager();
        };
    }
}
