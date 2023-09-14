package com.quangminh.spenvers;

import com.quangminh.spenvers.service.BookstoreService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootEnversApplication {


    private final BookstoreService bookstoreService;

    public SpringBootEnversApplication(BookstoreService bookstoreService) {
        this.bookstoreService = bookstoreService;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootEnversApplication.class, args);
    }

    @Bean
    public ApplicationRunner init() {
        return args -> {

            System.out.println("\nQuery entity history ...");
            System.out.println("------------------------");
            bookstoreService.queryEntityHistory();

            System.out.println("\nRegister new author ...");
            System.out.println("-----------------------");
            bookstoreService.registerAuthor();

            Thread.sleep(5000);

            System.out.println("\nUpdate an author ...");
            System.out.println("--------------------");
            bookstoreService.updateAuthor();

            Thread.sleep(5000);
            System.out.println("\nUpdate books of an author ...");
            System.out.println("-----------------------------");
            bookstoreService.updateBooks();

            System.out.println("\nQuery entity history ...");
            System.out.println("------------------------");
            bookstoreService.queryEntityHistory();
        };
    }
}
