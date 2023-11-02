package com.quangminh.enumattributeconverter.service;

import com.quangminh.enumattributeconverter.entity.Author;
import com.quangminh.enumattributeconverter.repository.AuthorRepository;
import org.springframework.stereotype.Service;

@Service
public class BookstoreService {

    private final AuthorRepository authorRepository;

    public BookstoreService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }
    public Author fetchAuthor(long authorId) {
        Author author = authorRepository.findById(authorId).orElseThrow();
        System.out.println(author);
        return author;
    }
}
