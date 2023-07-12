package com.quangminh.mapbooleanyesno.service;

import com.quangminh.mapbooleanyesno.entity.Author;
import com.quangminh.mapbooleanyesno.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookstoreService {
    private final AuthorRepository authorRepository;

    public Author persistAuthor(Author author){
        return authorRepository.save(author);
    }

    public Author fechAuthor(String name){
        return authorRepository.findByName(name);
    }

}
