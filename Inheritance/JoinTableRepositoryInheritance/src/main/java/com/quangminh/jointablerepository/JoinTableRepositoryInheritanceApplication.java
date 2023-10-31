package com.quangminh.jointablerepository;

import com.quangminh.jointablerepository.service.BookstoreService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JoinTableRepositoryInheritanceApplication {


    private final BookstoreService bookstoreService;

    public JoinTableRepositoryInheritanceApplication(BookstoreService bookstoreService) {
        this.bookstoreService = bookstoreService;
    }

    public static void main(String[] args) {
        SpringApplication.run(JoinTableRepositoryInheritanceApplication.class, args);
    }
    @Bean
    public ApplicationRunner init() {
        return args -> {
            System.out.println("\n\npersistAuthorWithBooks():");
            bookstoreService.persistAuthorWithBooks();

            System.out.println("\n\nfetchBookByTitle():");
            bookstoreService.fetchBookByTitle();

            System.out.println("\n\nfetchBookByIsbn():");
            bookstoreService.fetchBookByIsbn();
        };
    }

}
