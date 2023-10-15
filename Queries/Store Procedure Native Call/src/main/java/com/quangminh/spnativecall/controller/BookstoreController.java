package com.quangminh.spnativecall.controller;

import com.quangminh.spnativecall.service.BookstoreService;
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
    public ResponseEntity<?> fetchAnthologyAuthors(@PathVariable String genre){
        return new ResponseEntity<>(bookstoreService.fetchAnthologyAuthors(genre), HttpStatus.OK);
    }

    @GetMapping("/name-age/{genre}")
    public ResponseEntity<?> fetchAnthologyAuthorsNameAndAgeDto(@PathVariable String genre){
        return new ResponseEntity<>(bookstoreService.fetchAnthologyAuthorsNameAndAgeDto(genre), HttpStatus.OK);
    }

    @GetMapping("/name-age-proj/{genre}")
    public ResponseEntity<?> fetchAnthologyAuthorsNameAndAgeProj(@PathVariable String genre){
        return new ResponseEntity<>(bookstoreService.fetchAnthologyAuthorsNameAndAgeProj(genre), HttpStatus.OK);
    }

}
