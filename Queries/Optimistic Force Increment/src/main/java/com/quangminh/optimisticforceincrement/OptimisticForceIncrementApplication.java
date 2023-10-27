package com.quangminh.optimisticforceincrement;

import com.quangminh.optimisticforceincrement.service.BookstoreService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OptimisticForceIncrementApplication {


    private final BookstoreService bookstoreService;

    public OptimisticForceIncrementApplication(BookstoreService bookstoreService) {
        this.bookstoreService = bookstoreService;
    }

    public static void main(String[] args) {
        SpringApplication.run(OptimisticForceIncrementApplication.class, args);
    }
    @Bean
    public ApplicationRunner init() {
        return args -> {

            // running this application will
            // throw org.springframework.orm.ObjectOptimisticLockingFailureException

            bookstoreService.editChapter();
        };
    }
}
