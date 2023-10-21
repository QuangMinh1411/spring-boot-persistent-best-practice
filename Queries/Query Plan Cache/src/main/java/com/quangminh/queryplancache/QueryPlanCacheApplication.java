package com.quangminh.queryplancache;

import com.quangminh.queryplancache.service.BookstoreService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class QueryPlanCacheApplication {


    private final BookstoreService bookstoreService;

    public QueryPlanCacheApplication(BookstoreService bookstoreService) {
        this.bookstoreService = bookstoreService;
    }

    public static void main(String[] args) {
        SpringApplication.run(QueryPlanCacheApplication.class, args);
    }

    @Bean
    public ApplicationRunner init(){
        return args -> {
            bookstoreService.fetAuthorsbyGenre("comedy",30);
        };
    }
}
