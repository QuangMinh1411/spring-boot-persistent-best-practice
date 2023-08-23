package com.quangminh.delayconnection;

import com.quangminh.delayconnection.service.BookstoreService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DelayConnectionApplication {


    private final BookstoreService bookstoreService;

    public DelayConnectionApplication(BookstoreService bookstoreService) {
        this.bookstoreService = bookstoreService;
    }

    public static void main(String[] args) {
        SpringApplication.run(DelayConnectionApplication.class, args);
    }
    @Bean
    public ApplicationRunner init(){
        return args -> {
            bookstoreService.doTimeConsumingTask();
        };
    }
}
