package com.quangminh.enumstringint.controller;

import com.quangminh.enumstringint.service.BookstoreService;
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
    @GetMapping("/{authorId}")
    public ResponseEntity<?> fetchAuthor(@PathVariable Long authorId){
        return new ResponseEntity<>(bookstoreService.fetchAuthor(authorId), HttpStatus.OK);
    }
}
