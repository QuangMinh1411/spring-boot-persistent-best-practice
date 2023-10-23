package com.quangminh.parentchildseparate.controller;

import com.quangminh.parentchildseparate.entity.Author;
import com.quangminh.parentchildseparate.entity.Book;
import com.quangminh.parentchildseparate.service.BookstoreService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class BookstoreController {

    private final BookstoreService bookstoreService;

    public BookstoreController(BookstoreService bookstoreService) {
        this.bookstoreService = bookstoreService;
    }
    @GetMapping("/authors/{id}")
    public ResponseEntity<?> fetchAuthor(@PathVariable long id){
        return new ResponseEntity<>(bookstoreService.fetchAuthor(id), HttpStatus.OK);
    }
    @GetMapping("/authors/{id}/books")
    public ResponseEntity<?> fetchBooksOfAuthorGood(@PathVariable long id){
        Author author = bookstoreService.fetchAuthor(id);
        return new ResponseEntity<>(bookstoreService.fetchBooksOfAuthorGood(author), HttpStatus.OK);
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<?> fetchBook(@PathVariable long id){
        return new ResponseEntity<>(bookstoreService.fetchBook(id),HttpStatus.OK);
    }

    @GetMapping("/books/{id}/author")
    public ResponseEntity<?> fetchAuthorOfBookGood(@PathVariable long id){
        Book book = bookstoreService.fetchBook(id);
        return new ResponseEntity<>(bookstoreService.fetchAuthorOfBookGood(book),HttpStatus.OK);
    }
}
