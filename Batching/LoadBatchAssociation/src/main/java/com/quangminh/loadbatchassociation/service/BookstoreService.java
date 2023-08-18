package com.quangminh.loadbatchassociation.service;

import com.quangminh.loadbatchassociation.entity.Author;
import com.quangminh.loadbatchassociation.entity.Book;
import com.quangminh.loadbatchassociation.repository.AuthorRepository;
import com.quangminh.loadbatchassociation.repository.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookstoreService {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BookstoreService(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }
    @Transactional(readOnly = true)
    public List<Author> displayAuthorsAndBooks(){
        return authorRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<Book> displayBooksAndAuthors(){
        return bookRepository.findAll();
    }
}
