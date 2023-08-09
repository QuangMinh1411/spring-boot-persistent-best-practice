package com.quangminh.insertorderbatch;

import com.quangminh.insertorderbatch.impl.BatchRepositoryImpl;
import com.quangminh.insertorderbatch.service.BookstoreService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(repositoryBaseClass = BatchRepositoryImpl.class)
public class InsertOrderBatchPerTransactionApplication {


    private final BookstoreService bookstoreService;

    public InsertOrderBatchPerTransactionApplication(BookstoreService bookstoreService) {
        this.bookstoreService = bookstoreService;
    }

    public static void main(String[] args) {
        SpringApplication.run(InsertOrderBatchPerTransactionApplication.class, args);
    }

    @Bean
    public ApplicationRunner init() {
        return args -> {
            bookstoreService.batchAuthorsAndBooks();
        };
    }
}
