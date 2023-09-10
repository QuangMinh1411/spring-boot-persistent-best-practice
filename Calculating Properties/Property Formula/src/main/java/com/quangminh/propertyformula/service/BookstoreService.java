package com.quangminh.propertyformula.service;

import com.quangminh.propertyformula.entity.Book;
import com.quangminh.propertyformula.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookstoreService {

    private final BookRepository bookRepository;

    public BookstoreService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> fetchBooks() {
        List<Book> books = bookRepository.findAll();

        books.forEach(System.out::println);
        return books;
    }
}
