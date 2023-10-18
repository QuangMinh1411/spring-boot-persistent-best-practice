package com.quangminh.topnrowsgroup.controller;

import com.quangminh.topnrowsgroup.service.BookstoreService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authors")
public class BookstoreController {

    private final BookstoreService bookstoreService;

    public BookstoreController(BookstoreService bookstoreService) {
        this.bookstoreService = bookstoreService;
    }

    @GetMapping("/sales/{top}")
    public ResponseEntity<?> fetchAuthorTopBySales(@PathVariable int top){
        return new ResponseEntity<>(bookstoreService.fetchAuthorTopBySales(top), HttpStatus.OK);
    }
}
