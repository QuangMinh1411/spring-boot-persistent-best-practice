package com.quangminh.storeprocedure.controller;

import com.quangminh.storeprocedure.service.BookstoreService;
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
    @GetMapping("/{genre}")
    public ResponseEntity<?> countAuthorByGenre(@PathVariable String genre){
        return new ResponseEntity<>("Total count of "+ genre+" is: "+bookstoreService.countAnthologyAuthors(genre), HttpStatus.OK);
    }
}
