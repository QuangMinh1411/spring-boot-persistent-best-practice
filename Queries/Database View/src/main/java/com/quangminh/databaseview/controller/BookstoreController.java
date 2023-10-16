package com.quangminh.databaseview.controller;

import com.quangminh.databaseview.service.BookstoreService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/genre-title")
public class BookstoreController {

    private final BookstoreService bookstoreService;

    public BookstoreController(BookstoreService bookstoreService) {
        this.bookstoreService = bookstoreService;
    }
    @GetMapping
    public ResponseEntity<?> displayView(){
        return new ResponseEntity<>(bookstoreService.displayView(), HttpStatus.OK);
    }

    @GetMapping("/{genre}")
    public ResponseEntity<?> displayViewByGenre(@PathVariable String genre){
        return new ResponseEntity<>(bookstoreService.displayViewByGenre(genre), HttpStatus.OK);
    }
}
