package com.example.namedentitygraph.controller;

import com.example.namedentitygraph.service.BookstoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class BookstoreController {
    private final BookstoreService service;

    @GetMapping("/authors")
    public ResponseEntity<?> displayAuthorandBooks(){
        return new ResponseEntity<>(service.displayAuthorAndBooks(), HttpStatus.OK);
    }

    @GetMapping("/authors/{age}")
    public ResponseEntity<?> displayAuthorsAndBooksByAge(@PathVariable int age){
        return new ResponseEntity<>(service.displayAuthorsAndBooksByAge(age),HttpStatus.OK);
    }

    @GetMapping("/authors/specs")
    public ResponseEntity<?> displayAuthorGreaterThan45(){
        return new ResponseEntity<>(service.displayAuthorsAnBooksByAgeWithSpec(),HttpStatus.OK);
    }

    @GetMapping("/authors/age")
    public ResponseEntity<?> displayAuthorAndBookBetween(@RequestParam("low") int low,@RequestParam("high") int high){
        return new ResponseEntity<>(service.displayAuthorsAndBookFetchAllAgeBetween(low,high),HttpStatus.OK);
    }

    @GetMapping("/books")
    public ResponseEntity<?> displayBookandAuthor(){
        return ResponseEntity.ok(service.displayBooksAndAuthor());
    }
}
