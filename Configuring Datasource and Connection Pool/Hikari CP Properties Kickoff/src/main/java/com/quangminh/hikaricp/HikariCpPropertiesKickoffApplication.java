package com.quangminh.hikaricp;

import com.quangminh.hikaricp.repository.NumberRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootApplication
public class HikariCpPropertiesKickoffApplication {
    private static final ExecutorService executor = Executors.newFixedThreadPool(25);

    private final NumberRepository numberRepository;

    public HikariCpPropertiesKickoffApplication(NumberRepository numberRepository) {
        this.numberRepository = numberRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(HikariCpPropertiesKickoffApplication.class, args);
    }

    @Bean
    public ApplicationRunner init() {
        return args -> {

            while (true) {
                executor.execute(numberRepository);

                Thread.sleep((int) (Math.random() * 250));
            }

        };
    }
}
