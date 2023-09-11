package com.quangminh.traceview.service;

import com.quangminh.traceview.entity.Author;
import com.quangminh.traceview.repository.AuthorRepository;
import org.springframework.stereotype.Service;

@Service
public class BookstoreService {

    private final AuthorRepository authorRepository;

    public BookstoreService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }
    public void persistAuthor() {
        Author author = new Author();
        author.setName("Joana Nimar");
        author.setGenre("History");
        author.setAge(34);

        authorRepository.save(author);
    }

    public void displayAuthor() {

        Author author = authorRepository.findById(1L).orElseThrow();

        System.out.println(author);
    }
}
