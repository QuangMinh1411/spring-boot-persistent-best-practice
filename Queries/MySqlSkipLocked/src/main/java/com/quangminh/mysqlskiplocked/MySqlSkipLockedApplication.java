package com.quangminh.mysqlskiplocked;

import com.quangminh.mysqlskiplocked.repository.BookRepository;
import com.quangminh.mysqlskiplocked.service.BookstoreService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MySqlSkipLockedApplication {


    private final BookstoreService bookstoreService;

    public MySqlSkipLockedApplication(BookstoreService bookstoreService) {
        this.bookstoreService = bookstoreService;
    }

    public static void main(String[] args) {
        SpringApplication.run(MySqlSkipLockedApplication.class, args);
    }
    @Bean
    public ApplicationRunner init() {
        return args -> {bookstoreService.fetchBooksViaTwoTransactions();
        };
    }
}
