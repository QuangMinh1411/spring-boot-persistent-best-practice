package com.quangminh.pessimisticlocks;

import com.quangminh.pessimisticlocks.service.BookstoreService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PesimisticLocksApplication {


    private final BookstoreService bookstoreService;

    public PesimisticLocksApplication(BookstoreService bookstoreService) {
        this.bookstoreService = bookstoreService;
    }

    public static void main(String[] args) {
        SpringApplication.run(PesimisticLocksApplication.class, args);
    }

    @Bean
    public ApplicationRunner init() {
        return args -> {
            // calling the below method will throw:
            // org.springframework.dao.QueryTimeoutException
            // Caused by: org.hibernate.QueryTimeoutException
            System.out.println("\n\nPESSIMISTIC_READ/WRITE ...");
            System.out.println("------------------------");
            bookstoreService.pessimisticReadWrite();
        };
    }
}
