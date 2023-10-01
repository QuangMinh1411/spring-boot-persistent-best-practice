package com.quangminh.derivedcountdelete.service;

import com.quangminh.derivedcountdelete.entity.Author;
import com.quangminh.derivedcountdelete.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookstoreService {

    private final AuthorRepository authorRepository;

    public BookstoreService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }
    public long countByGenre(String genre) {

        return authorRepository.countByGenre(genre);
    }

    public long deleteByGenre(String genre) {

        return authorRepository.deleteByGenre(genre);
    }

    public List<Author> removeByGenre(String genre) {

        return authorRepository.removeByGenre(genre);
    }
}
