package com.quangminh.jsonhibernate5.controller;

import com.quangminh.jsonhibernate5.service.BookstoreService;
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

    @GetMapping("/fetchWithBooks/{name}")
    public ResponseEntity<?> fetchAuthorWithBooks(@PathVariable String name){
        return new ResponseEntity<>(bookstoreService.fetchAuthorWithBooks(name), HttpStatus.OK);
    }

    @GetMapping ("/fetchwithoutbooks/{name}")
    public ResponseEntity<?> fetchAuthorWithoutBooks(@PathVariable String name) {
        return new ResponseEntity<>(bookstoreService.fetchAuthorWithoutBooks(name),HttpStatus.OK);
    }
}
