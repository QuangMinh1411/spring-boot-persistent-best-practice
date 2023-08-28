package com.quangminh.hilo.service;

import com.quangminh.hilo.entity.Author;
import com.quangminh.hilo.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookstoreService {

    private final AuthorRepository authorRepository;

    public BookstoreService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public void batch1000Authors() {

        List<Author> authors = new ArrayList<>();

        for (int i = 1; i <= 1000; i++) {
            Author author = new Author();
            author.setName("Author_" + i);

            authors.add(author);
        }

        authorRepository.saveAll(authors);
    }
}