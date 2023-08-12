package com.quangminh.batchjsonfileforkjoin;

import com.quangminh.batchjsonfileforkjoin.forkjoin.ForkJoinService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BatchJsonfileForkjoinApplication {
    private static final String FILE_NAME = "citylots.json";

    private final ForkJoinService forkJoinService;

    public BatchJsonfileForkjoinApplication(ForkJoinService forkJoinService) {
        this.forkJoinService = forkJoinService;
    }

    public static void main(String[] args) {
        SpringApplication.run(BatchJsonfileForkjoinApplication.class, args);
    }
    @Bean
    public ApplicationRunner init() {
        return args -> {

            forkJoinService.fileToDatabase(FILE_NAME);
        };
    }
}
