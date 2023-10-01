package com.quangminh.derivedcountdelete.controller;

import com.quangminh.derivedcountdelete.service.BookstoreService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authors")
public class BookstoreController {

    private final BookstoreService bookstoreService;

    public BookstoreController(BookstoreService bookstoreService) {
        this.bookstoreService = bookstoreService;
    }
    @GetMapping("/count/{genre}")
    public ResponseEntity<?> contByGenre(@PathVariable String genre){
        return new ResponseEntity<>(bookstoreService.countByGenre(genre), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{genre}")
    public ResponseEntity<?> deleteByGenre(@PathVariable String genre){
        return new ResponseEntity<>(bookstoreService.deleteByGenre(genre),HttpStatus.OK);
    }

    @DeleteMapping("/remove/{genre}")
    public ResponseEntity<?> removeByGenre(@PathVariable String genre){
        return new ResponseEntity<>(bookstoreService.removeByGenre(genre),HttpStatus.OK);
    }
}
