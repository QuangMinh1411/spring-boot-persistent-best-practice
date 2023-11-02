package com.quangminh.mappedsuperclass.controller;

import com.quangminh.mappedsuperclass.service.BookstoreService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookstoreController {

    private final BookstoreService bookstoreService;

    public BookstoreController(BookstoreService bookstoreService) {
        this.bookstoreService = bookstoreService;
    }
    @GetMapping("/title/{title}")
    public ResponseEntity<?> fetchBookByTitle(@PathVariable String title){
        return new ResponseEntity<>(bookstoreService.fetchBookByTitle(title), HttpStatus.OK);
    }
    @GetMapping("/isbn/{isbn}")
    public ResponseEntity<?> fetchBookByIsbn(@PathVariable String isbn){
        return new ResponseEntity<>(bookstoreService.fetchBookByIsbn(isbn),HttpStatus.OK);
    }
}
