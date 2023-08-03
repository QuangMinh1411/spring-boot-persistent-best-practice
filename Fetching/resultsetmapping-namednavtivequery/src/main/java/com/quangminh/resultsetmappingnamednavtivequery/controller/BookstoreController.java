package com.quangminh.resultsetmappingnamednavtivequery.controller;

import com.quangminh.resultsetmappingnamednavtivequery.service.BookstoreService;
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
    public ResponseEntity<?> fetchAuthors(){
        return new ResponseEntity<>(bookstoreService.fetchAuthors(), HttpStatus.OK);
    }
    @GetMapping("/name-age")
    public ResponseEntity<?> fetchAuthorNameAndAge(){
        return new ResponseEntity<>(bookstoreService.fetchAuthorWithBook(), HttpStatus.OK);
    }
}
