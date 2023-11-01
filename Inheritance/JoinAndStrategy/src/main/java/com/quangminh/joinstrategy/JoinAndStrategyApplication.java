package com.quangminh.joinstrategy;

import com.quangminh.joinstrategy.service.BookstoreService;
import com.quangminh.joinstrategy.visitor.BookCoverVisitor;
import com.quangminh.joinstrategy.visitor.BookFixHiperlinksVisitor;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JoinAndStrategyApplication {


    private final BookstoreService bookstoreService;

    public JoinAndStrategyApplication(BookstoreService bookstoreService) {
        this.bookstoreService = bookstoreService;
    }

    public static void main(String[] args) {
        SpringApplication.run(JoinAndStrategyApplication.class, args);
    }
    @Bean
    public ApplicationRunner init() {
        return args -> {
            bookstoreService.persistAuthorWithBooks();
            bookstoreService.applyDelivers();

            bookstoreService.persistAuthorWithBooks();
            bookstoreService.applyVisitor(BookCoverVisitor.class);
            bookstoreService.applyVisitor(BookFixHiperlinksVisitor.class);
        };
    }

}
