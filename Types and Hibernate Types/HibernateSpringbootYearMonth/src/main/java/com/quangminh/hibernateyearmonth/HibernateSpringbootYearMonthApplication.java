package com.quangminh.hibernateyearmonth;

import com.quangminh.hibernateyearmonth.service.BookstoreService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HibernateSpringbootYearMonthApplication {


    private final BookstoreService bookstoreService;

    public HibernateSpringbootYearMonthApplication(BookstoreService bookstoreService) {
        this.bookstoreService = bookstoreService;
    }

    public static void main(String[] args) {
        SpringApplication.run(HibernateSpringbootYearMonthApplication.class, args);
    }
    @Bean
    public ApplicationRunner init() {
        return args -> {
            bookstoreService.newBook();
            bookstoreService.displayBook();
        };
    }
}
