package com.quangminh.log4jdbc;

import com.quangminh.log4jdbc.service.BookstoreService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Log4JdbcViewBindingParametersApplication {

    private final BookstoreService bookstoreService;

    public Log4JdbcViewBindingParametersApplication(BookstoreService bookstoreService) {
        this.bookstoreService = bookstoreService;
    }

    public static void main(String[] args) {
        SpringApplication.run(Log4JdbcViewBindingParametersApplication.class, args);
    }
    @Bean
    public ApplicationRunner init() {
        return args -> {

            bookstoreService.persistAuthor();
            bookstoreService.displayAuthor();
        };
    }

}
