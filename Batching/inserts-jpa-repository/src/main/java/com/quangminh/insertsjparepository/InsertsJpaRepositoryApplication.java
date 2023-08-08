package com.quangminh.insertsjparepository;

import com.quangminh.insertsjparepository.service.BookstoreService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InsertsJpaRepositoryApplication implements CommandLineRunner {


    private final BookstoreService bookstoreService;

    public InsertsJpaRepositoryApplication(BookstoreService bookstoreService) {
        this.bookstoreService = bookstoreService;
    }

    public static void main(String[] args) {
        SpringApplication.run(InsertsJpaRepositoryApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        bookstoreService.batchAuthors();
    }
}
