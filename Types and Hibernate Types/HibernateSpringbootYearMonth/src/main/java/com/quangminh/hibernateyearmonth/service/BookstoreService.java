package com.quangminh.hibernateyearmonth.service;

import com.quangminh.hibernateyearmonth.entity.Book;
import com.quangminh.hibernateyearmonth.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.time.YearMonth;

@Service
public class BookstoreService {

    private final BookRepository bookRepository;

    public BookstoreService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    public void newBook() {

        Book book = new Book();

        book.setIsbn("001");
        book.setTitle("Young Boy");
        book.setReleaseDate(YearMonth.now());

        bookRepository.save(book);
    }

    public void displayBook() {
        Book book = bookRepository.findByTitle("Young Boy");

        System.out.println(book);
    }
}
