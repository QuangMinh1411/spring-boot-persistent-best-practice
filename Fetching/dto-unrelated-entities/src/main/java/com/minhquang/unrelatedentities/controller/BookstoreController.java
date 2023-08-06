package com.minhquang.unrelatedentities.controller;

import com.minhquang.unrelatedentities.service.BookstoreService;
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

    @GetMapping("/{price}")
    public ResponseEntity<?> fetchAuthorNameBookTitleWithPrice(@PathVariable int price){
        return new ResponseEntity<>(bookstoreService.fetchAuthorNameBookTitleWithPrice(price), HttpStatus.OK);
    }
}
