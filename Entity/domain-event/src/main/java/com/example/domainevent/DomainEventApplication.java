package com.example.domainevent;

import com.example.domainevent.service.BookstoreService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.logging.Logger;

@EnableAsync
@SpringBootApplication
public class DomainEventApplication {


	public static void main(String[] args) {
		SpringApplication.run(DomainEventApplication.class, args);
	}



}
