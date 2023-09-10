package com.quangminh.propertypostload.controller;

import com.quangminh.propertypostload.service.BookstoreService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookstoreController {

    private final BookstoreService bookstoreService;

    public BookstoreController(BookstoreService bookstoreService) {
        this.bookstoreService = bookstoreService;
    }

    @GetMapping
    public ResponseEntity<?> fetchAll(){
        return new ResponseEntity<>(bookstoreService.fetchBooks(), HttpStatus.OK);
    }
}
