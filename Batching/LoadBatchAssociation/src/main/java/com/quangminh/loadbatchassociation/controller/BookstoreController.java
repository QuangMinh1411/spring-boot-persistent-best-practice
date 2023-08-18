package com.quangminh.loadbatchassociation.controller;

import com.quangminh.loadbatchassociation.service.BookstoreService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class BookstoreController {

    private final BookstoreService bookstoreService;

    public BookstoreController(BookstoreService bookstoreService) {
        this.bookstoreService = bookstoreService;
    }

    @GetMapping("/authors")
    public ResponseEntity<?> displayAuthors(){
        return new ResponseEntity<>(bookstoreService.displayAuthorsAndBooks(), HttpStatus.OK);
    }
    @GetMapping("/books")
    public ResponseEntity<?> displayBooks(){
        return new ResponseEntity<>(bookstoreService.displayBooksAndAuthors(), HttpStatus.OK);
    }
}
