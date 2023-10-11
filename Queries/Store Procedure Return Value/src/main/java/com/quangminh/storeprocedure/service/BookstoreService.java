package com.quangminh.storeprocedure.service;

import com.quangminh.storeprocedure.repository.AuthorRepository;
import org.springframework.stereotype.Service;

@Service
public class BookstoreService {

    private final AuthorRepository authorRepository;

    public BookstoreService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }
    public Integer countAnthologyAuthors(String genre) {
        return authorRepository.countByGenre(genre);
    }
}
