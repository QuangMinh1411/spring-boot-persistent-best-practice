package com.quangminh.unpoxy;

import com.quangminh.unpoxy.service.BookstoreService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class UnproxyAProxyApplication {


    private final BookstoreService bookstoreService;

    public UnproxyAProxyApplication(BookstoreService bookstoreService) {
        this.bookstoreService = bookstoreService;
    }

    public static void main(String[] args) {
        SpringApplication.run(UnproxyAProxyApplication.class, args);
    }

    @Bean
    public ApplicationRunner init(){
        return args -> {
            bookstoreService.authorNotEqualsProxy();
            System.out.println("----------------");
            bookstoreService.authorEqualsUnproxy();
        };
    }
}
