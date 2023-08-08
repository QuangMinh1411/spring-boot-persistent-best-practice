package com.quangminh.batchperpersistent;

import com.quangminh.batchperpersistent.impl.BatchRepositoryImpl;
import com.quangminh.batchperpersistent.service.BookstoreService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(repositoryBaseClass = BatchRepositoryImpl.class)
public class BatchInsertSpringBatchPerPersistentApplication {


    private final BookstoreService bookstoreService;

    public BatchInsertSpringBatchPerPersistentApplication(BookstoreService bookstoreService) {
        this.bookstoreService = bookstoreService;
    }

    public static void main(String[] args) {
        SpringApplication.run(BatchInsertSpringBatchPerPersistentApplication.class, args);
    }

    @Bean
    public ApplicationRunner init() {
        return args -> {
            bookstoreService.batchAuthors();
        };
    }
}
