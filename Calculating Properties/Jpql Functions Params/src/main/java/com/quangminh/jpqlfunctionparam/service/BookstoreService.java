package com.quangminh.jpqlfunctionparam.service;

import com.quangminh.jpqlfunctionparam.dao.Dao;
import com.quangminh.jpqlfunctionparam.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class BookstoreService {

    private final BookRepository bookRepository;
    private final Dao dao;

    public BookstoreService(BookRepository bookRepository, Dao dao) {
        this.bookRepository = bookRepository;
        this.dao = dao;
    }
    public String titleAndPrice(Long id){
        return bookRepository.fetchTitleAndPrice("$", Instant.now(),id);
        // or, via EntityManager from Dao class
        //return dao.fetchNameAndAmount("$", Instant.now());
    }
}
