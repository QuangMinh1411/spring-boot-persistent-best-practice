package com.quangminh.extracolumn.controller;

import com.quangminh.extracolumn.service.BookstoreService;
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

    @GetMapping("/{page}/{size}")
    public ResponseEntity<?> fetchAuthors(@PathVariable int page,@PathVariable int size){
        return new ResponseEntity<>(bookstoreService.fetchNextPage(page, size), HttpStatus.OK);
    }

    @GetMapping("/list/{page}/{size}")
    public ResponseEntity<?> fetchAuthorsList(@PathVariable int page,@PathVariable int size){
        return new ResponseEntity<>(bookstoreService.fetchNextPageList(page, size), HttpStatus.OK);
    }
}
