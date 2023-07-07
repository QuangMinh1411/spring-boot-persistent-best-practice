package com.quangminh.filterassociation.service;

import com.quangminh.filterassociation.entity.Author;
import com.quangminh.filterassociation.entity.Book;
import com.quangminh.filterassociation.repository.AuthorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookstoreService {
    private final AuthorRepository authorRepository;

    public BookstoreService(AuthorRepository authorRepository) {

        this.authorRepository = authorRepository;
    }

    @Transactional(readOnly = true)
    public List<Book> fetchAuthorWithAllBooks(Long id) {

        Author author = authorRepository.findById(id).orElseThrow();
        return author.getBooks();

    }

    @Transactional(readOnly = true)
    public List<Book> fetchAuthorWithCheapBooks(Long id) {

        Author author = authorRepository.findById(id).orElseThrow();
        return author.getCheapBooks();


    }

    @Transactional(readOnly = true)
    public List<Book> fetchAuthorWithRestOfBooks(Long id) {

        Author author = authorRepository.findById(id).orElseThrow();
        return author.getRestOfBooks();


    }
}
