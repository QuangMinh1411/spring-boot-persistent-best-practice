package com.quangminh.filterassociation.controller;

import com.quangminh.filterassociation.service.BookstoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookstoreController {
    private final BookstoreService service;

    @GetMapping("/{id}")
    public ResponseEntity<?> fetchAuthorWithAllBooks(@PathVariable long id){
        return new ResponseEntity<>(service.fetchAuthorWithAllBooks(id), HttpStatus.OK);
    }

    @GetMapping("/cheap/{id}")
    public ResponseEntity<?> fetchAuthorWithCheapBooks(@PathVariable long id){
        return new ResponseEntity<>(service.fetchAuthorWithCheapBooks(id), HttpStatus.OK);
    }

    @GetMapping("/rest/{id}")
    public ResponseEntity<?> fetchAuthorWithRestOfBooks(@PathVariable long id){
        return new ResponseEntity<>(service.fetchAuthorWithRestOfBooks(id), HttpStatus.OK);
    }
}
