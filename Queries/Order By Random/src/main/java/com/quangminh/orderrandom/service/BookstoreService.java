package com.quangminh.orderrandom.service;

import com.quangminh.orderrandom.entity.Book;
import com.quangminh.orderrandom.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookstoreService {

    private final BookRepository bookRepository;

    public BookstoreService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    public List<Book> fetchBooksOrderByRnd() {
        return bookRepository.fetchOrderByRnd();
    }
}
