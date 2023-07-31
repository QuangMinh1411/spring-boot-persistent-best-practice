package com.quangminh.dtoconstructor.controller;

import com.quangminh.dtoconstructor.service.BookstoreService;
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

    @GetMapping
    public ResponseEntity<?> getAuthors(){
        return new ResponseEntity<>(bookstoreService.fetchAuthor(),HttpStatus.OK);
    }

    @GetMapping("/{genre}")
    public ResponseEntity<?> getAllAuthors(@PathVariable String genre){
        return new ResponseEntity<>(bookstoreService.fetchByGenre(genre), HttpStatus.OK);
    }
}
