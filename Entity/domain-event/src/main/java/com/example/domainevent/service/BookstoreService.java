package com.example.domainevent.service;

import com.example.domainevent.entity.Book;
import com.example.domainevent.entity.BookReview;
import com.example.domainevent.repository.BookRepository;
import com.example.domainevent.repository.BookReviewRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookstoreService {
    private static final String RESPONSE = "We check your review and get back to you with an email ASAP";

    private final BookRepository bookRepository;
    private final BookReviewRepository bookReviewRepository;

    public BookstoreService(BookRepository bookRepository, BookReviewRepository bookReviewRepository) {
        this.bookRepository = bookRepository;
        this.bookReviewRepository = bookReviewRepository;
    }

    public Book insertBook(Book book){
        return bookRepository.save(book);
    }

    @Transactional
    public String postReview(Long id,BookReview bookReview){
        Book book = bookRepository.findById(id).orElse(null);
        if(book!=null){
            bookReview.setBook(book);
            bookReview.registerReviewEvent();
            bookReviewRepository.save(bookReview);
            return RESPONSE;
        }
        else{
            return "Not found";
        }
    }
}
