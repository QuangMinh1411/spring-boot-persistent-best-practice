package com.example.namedentitygraph.service;

import com.example.namedentitygraph.entity.Author;
import com.example.namedentitygraph.entity.Book;
import com.example.namedentitygraph.repository.AuthorRepository;
import com.example.namedentitygraph.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.namedentitygraph.specs.AuthorSpecs.isAgeGt45;

@Service
@RequiredArgsConstructor
public class BookstoreService {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public List<Author> displayAuthorAndBooks(){
        return authorRepository.findAll();
    }

    public List<Author> displayAuthorsAnBooksByAgeWithSpec(){
        return authorRepository.findAll(isAgeGt45());
    }

    public List<Author> displayAuthorsAndBooksByAge(int age){
        return authorRepository.findByAgeLessThanOrderByNameDesc(age);
    }

    public List<Author> displayAuthorsAndBookFetchAllAgeBetween(int low,int high){
        return authorRepository.fetchAllAgeBetween(low,high);
    }

    public List<Book> displayBooksAndAuthor(){
        return bookRepository.findAll();
    }
}

