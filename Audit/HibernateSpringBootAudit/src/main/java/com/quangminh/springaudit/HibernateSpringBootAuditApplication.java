package com.quangminh.springaudit;

import com.quangminh.springaudit.auditor.AuditorAwareImpl;
import com.quangminh.springaudit.service.BookstoreService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class HibernateSpringBootAuditApplication {


    private final BookstoreService bookstoreService;

    public HibernateSpringBootAuditApplication(BookstoreService bookstoreService) {
        this.bookstoreService = bookstoreService;
    }

    public static void main(String[] args) {
        SpringApplication.run(HibernateSpringBootAuditApplication.class, args);
    }

    @Bean
    public AuditorAware<String> auditorAware() {
        return new AuditorAwareImpl();
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
