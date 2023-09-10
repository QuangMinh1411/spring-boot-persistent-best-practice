package com.quangminh.propertypostload.service;

import com.quangminh.propertypostload.entity.Book;
import com.quangminh.propertypostload.repository.BookRepository;
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
