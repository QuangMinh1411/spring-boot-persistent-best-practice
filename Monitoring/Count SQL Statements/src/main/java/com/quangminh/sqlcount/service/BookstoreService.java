package com.quangminh.sqlcount.service;

import com.quangminh.sqlcount.entity.Author;
import com.quangminh.sqlcount.repository.AuthorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookstoreService {

    private final AuthorRepository authorRepository;

    public BookstoreService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }
    public Author updateAuthorWithoutTransactional(Long id,String genre) {

        Author author = authorRepository.findById(id).orElseThrow();
        author.setGenre(genre);

        return authorRepository.save(author);

    }

    @Transactional
    public Author updateAuthorWithTransactional(Long id,String genre) {
        Author author = authorRepository.findById(id).orElseThrow();
        author.setGenre(genre);
        return author;
    }
}
