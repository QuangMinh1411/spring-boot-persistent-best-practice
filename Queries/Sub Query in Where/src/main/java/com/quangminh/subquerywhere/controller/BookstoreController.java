package com.quangminh.subquerywhere.controller;

import com.quangminh.subquerywhere.service.BookstoreService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authors")
public class BookstoreController {

    private final BookstoreService bookstoreService;

    public BookstoreController(BookstoreService bookstoreService) {
        this.bookstoreService = bookstoreService;
    }
    @GetMapping
    public ResponseEntity<?> displayTheBest(){
        return new ResponseEntity<>(bookstoreService.displayTheBest(), HttpStatus.OK);
    }
}
