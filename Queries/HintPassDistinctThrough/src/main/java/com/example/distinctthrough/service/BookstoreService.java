package com.example.distinctthrough.service;

import com.example.distinctthrough.entity.Author;
import com.example.distinctthrough.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookstoreService {

    private final AuthorRepository authorRepository;

    public BookstoreService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> fetchWithDuplicates() {
        System.out.println("\nFetching authors with duplicates ...");

        List<Author> authors = authorRepository.fetchWithDuplicates();

        authors.forEach(a -> {
            System.out.println("Id: " + a.getId() + ": Name: " + a.getName() + " Books: " + a.getBooks());
        });
        return authors;
    }

    public List<Author> fetchWithoutHint() {
        System.out.println("\nFetching authors without HINT_PASS_DISTINCT_THROUGH hint ...");

        List<Author> authors = authorRepository.fetchWithoutHint();

        authors.forEach(a -> {
            System.out.println("Id: " + a.getId() + ": Name: " + a.getName() + " Books: " + a.getBooks());
        });
        return authors;
    }

}
