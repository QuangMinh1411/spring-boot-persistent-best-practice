package com.quangminh.specificsubclassinheritance;

import com.quangminh.specificsubclassinheritance.service.BookstoreService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpecificSubclassFromInheritanceApplication {


//    private final BookstoreService bookstoreService;
//
//    public SpecificSubclassFromInheritanceApplication(BookstoreService bookstoreService) {
//        this.bookstoreService = bookstoreService;
//    }

    public static void main(String[] args) {
        SpringApplication.run(SpecificSubclassFromInheritanceApplication.class, args);
    }
//    @Bean
//    public ApplicationRunner init() {
//        return args -> {
//            bookstoreService.persistAuthorWithBooks();
//            bookstoreService.findEbookByAuthorNameViaEbookRepository();
//            bookstoreService.findEbookByAuthorNameViaBookRepository();
//        };
//    }

}
