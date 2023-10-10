package com.quangminh.subquerywhere.service;

import com.quangminh.subquerywhere.entity.Author;
import com.quangminh.subquerywhere.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookstoreService {

    private final AuthorRepository authorRepository;

    public BookstoreService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> displayTheBest(){
        return authorRepository.fetchTheBest();
    }
}
