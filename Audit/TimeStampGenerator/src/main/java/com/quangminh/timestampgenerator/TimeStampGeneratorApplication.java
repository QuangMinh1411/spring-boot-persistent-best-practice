package com.quangminh.timestampgenerator;

import com.quangminh.timestampgenerator.service.BookstoreService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TimeStampGeneratorApplication {


    private final BookstoreService bookstoreService;

    public TimeStampGeneratorApplication(BookstoreService bookstoreService) {
        this.bookstoreService = bookstoreService;
    }

    public static void main(String[] args) {
        SpringApplication.run(TimeStampGeneratorApplication.class, args);
    }

    @Bean
    public ApplicationRunner init() {
        return args -> {
            System.out.println("Register new author ...");
            bookstoreService.registerAuthor();

            Thread.sleep(5000);

            System.out.println("Update an author ...");
            bookstoreService.updateAuthor();

            Thread.sleep(5000);
            System.out.println("Update books of an author ...");
            bookstoreService.updateBooks();

        };
    }
}
