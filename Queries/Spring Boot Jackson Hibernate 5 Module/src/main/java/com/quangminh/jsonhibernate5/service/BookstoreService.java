package com.quangminh.jsonhibernate5.service;

import com.quangminh.jsonhibernate5.entity.Author;
import com.quangminh.jsonhibernate5.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookstoreService {

    private final AuthorRepository authorRepository;

    public BookstoreService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }
    public Author fetchAuthorWithBooks(String name) {

        return authorRepository.findByNameWithBooks(name);
    }

    public Optional<Author> fetchAuthorWithoutBooks(String name) {

        return authorRepository.findByName(name);
    }
}
