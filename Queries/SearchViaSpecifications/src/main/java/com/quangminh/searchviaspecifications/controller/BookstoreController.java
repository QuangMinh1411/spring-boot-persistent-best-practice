package com.quangminh.searchviaspecifications.controller;

import com.quangminh.searchviaspecifications.service.BookstoreService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bookstore")
public class BookstoreController {

    private final BookstoreService bookstoreService;

    public BookstoreController(BookstoreService bookstoreService) {
        this.bookstoreService = bookstoreService;
    }
    @GetMapping("/authors/{age}/{genre}")
    public ResponseEntity<?> fetchAuthors(@PathVariable int age,@PathVariable String genre){
        return new ResponseEntity<>(bookstoreService.fetchAuthors(age,genre), HttpStatus.OK);
    }
    @GetMapping("/books/{page}/{size}")
    public ResponseEntity<?> fetchBooksPage(@PathVariable int page,@PathVariable int size){
        return new ResponseEntity<>(bookstoreService.fetchBooksPage(page, size),HttpStatus.OK);
    }
}
