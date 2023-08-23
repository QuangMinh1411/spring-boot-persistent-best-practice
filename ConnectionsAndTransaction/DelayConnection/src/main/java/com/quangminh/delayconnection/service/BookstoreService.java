package com.quangminh.delayconnection.service;

import com.quangminh.delayconnection.entity.Author;
import com.quangminh.delayconnection.repository.AuthorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookstoreService {

    private final AuthorRepository authorRepository;

    public BookstoreService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Transactional
    public void doTimeConsumingTask() throws InterruptedException{
        System.out.println("Waiting for time consuming task not need a database connection");
        Thread.sleep(40000);
        System.out.println("Done, now query the database...");
        System.out.println("Database connection should be acquired now ...");
        Author author = authorRepository.findById(1L).get();
        Thread.sleep(40000);
        author.setAge(45);
    }
}
