package com.quangminh.traceview;

import com.quangminh.traceview.service.BookstoreService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TraceViewBindingParametersApplication {


    private final BookstoreService bookstoreService;

    public TraceViewBindingParametersApplication(BookstoreService bookstoreService) {
        this.bookstoreService = bookstoreService;
    }

    public static void main(String[] args) {
        SpringApplication.run(TraceViewBindingParametersApplication.class, args);
    }

    @Bean
    public ApplicationRunner init() {
        return args -> {

            bookstoreService.persistAuthor();
            bookstoreService.displayAuthor();
        };
    }
}
