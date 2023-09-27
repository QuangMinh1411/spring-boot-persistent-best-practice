package com.example.distinctthrough.controller;

import com.example.distinctthrough.service.BookstoreService;
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

    @GetMapping("/duplicat")
    public ResponseEntity<?> fetchWithDuplicates(){
        return new ResponseEntity<>(bookstoreService.fetchWithDuplicates(), HttpStatus.OK);
    }

    @GetMapping("/withoutHint")
    public ResponseEntity<?> fetchWithoutHint(){
        return new ResponseEntity<>(bookstoreService.fetchWithoutHint(),HttpStatus.OK);
    }
}
