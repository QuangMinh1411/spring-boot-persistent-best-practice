package com.quangminh.dtoviajoin.controller;

import com.quangminh.dtoviajoin.service.BookstoreService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authors")
public class BookstoreController {
    private final BookstoreService bookstoreService;

    public BookstoreController(BookstoreService bookstoreService) {
        this.bookstoreService = bookstoreService;
    }

    @GetMapping
    public ResponseEntity<?> findAuthorsAndBooksJpql(){
        return new ResponseEntity<>(bookstoreService.findAuthorsAndBooksJpql(),HttpStatus.OK);
    }

    @GetMapping("/genre-price")
    public ResponseEntity<?> findAuthorsAndBooksByGenreAndPriceJpql(@RequestParam("genre")String genre,@RequestParam("price")int price){
        return new ResponseEntity<>(bookstoreService.findAuthorsAndBooksByGenreAndPriceJpql(genre,price),HttpStatus.OK);
    }
    @GetMapping("/full")
    public ResponseEntity<?> fetchAuthorAndBookFull(){
        return new ResponseEntity<>(bookstoreService.fetchAuthorsAndBooksSqlFullJoin(),HttpStatus.OK);
    }
}
