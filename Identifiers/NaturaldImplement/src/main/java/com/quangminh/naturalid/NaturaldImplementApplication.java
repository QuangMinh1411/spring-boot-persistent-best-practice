package com.quangminh.naturalid;

import com.quangminh.naturalid.entity.Book;
import com.quangminh.naturalid.naturalId.NaturalRepositoryImpl;
import com.quangminh.naturalid.service.BookstoreService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(repositoryBaseClass = NaturalRepositoryImpl.class)
public class NaturaldImplementApplication {


    private final BookstoreService bookstoreService;

    public NaturaldImplementApplication(BookstoreService bookstoreService) {
        this.bookstoreService = bookstoreService;
    }

    public static void main(String[] args) {
        SpringApplication.run(NaturaldImplementApplication.class, args);
    }

    @Bean
    public ApplicationRunner init() {
        return args -> {

            bookstoreService.persistTwoBooks();

            Book book = bookstoreService.fetchFirstBookByNaturalId();
            System.out.println(book);
        };
    }
}
