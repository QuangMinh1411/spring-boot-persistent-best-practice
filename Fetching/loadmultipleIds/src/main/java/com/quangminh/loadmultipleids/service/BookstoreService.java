package com.quangminh.loadmultipleids.service;

import com.quangminh.loadmultipleids.entity.Book;
import com.quangminh.loadmultipleids.repository.BookMultipleIdsRepository;
import com.quangminh.loadmultipleids.repository.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookstoreService {
    private final BookMultipleIdsRepository bookMultipleIdsRepository;
    private final BookRepository bookRepository;

    public BookstoreService(BookMultipleIdsRepository bookMultipleIdsRepository,
                            BookRepository bookRepository) {
        this.bookMultipleIdsRepository = bookMultipleIdsRepository;
        this.bookRepository = bookRepository;
    }

    public List<Book> fetchByMultipleIdsIn(List<Long> ids) {
        List<Book> books = bookRepository.fetchByMultipleIds(ids);
        books.forEach(book -> System.out.println(book));
        return  books;
    }

    public List<Book> fetchByMultipleIds(List<Long> ids) {
        return bookMultipleIdsRepository
                .fetchByMultipleIds(ids);

    }

    public List<Book> fetchInBatchesByMultipleIds(List<Long> ids) {
        return bookMultipleIdsRepository
                .fetchInBatchesByMultipleIds(ids, 2);


    }

    @Transactional(readOnly = true)
    public List<Book> fetchBySessionCheckMultipleIds(List<Long> ids) {
        List<Book> books1 = bookMultipleIdsRepository
                .fetchByMultipleIds(ids);

        System.out.println(books1);

        // loaded from Persistence Context
        List<Book> books2 = bookMultipleIdsRepository
                .fetchBySessionCheckMultipleIds(ids);

        return books2;
    }

    public List<Book> fetchInBatchesBySessionCheckMultipleIds(List<Long> ids) {
        return bookMultipleIdsRepository
                .fetchInBatchesBySessionCheckMultipleIds(ids, 2);


    }
}
