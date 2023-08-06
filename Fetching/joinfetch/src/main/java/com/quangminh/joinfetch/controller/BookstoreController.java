package com.quangminh.joinfetch.controller;

import com.quangminh.joinfetch.service.BookstoreService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class BookstoreController {

    private final BookstoreService bookstoreService;

    public BookstoreController(BookstoreService bookstoreService) {
        this.bookstoreService = bookstoreService;
    }

    @GetMapping("/authors/{name}")
    public ResponseEntity<?> fetchAuthorsWithBookByName(@PathVariable String name){
        return new ResponseEntity<>(bookstoreService.fetchAuthorWithBooksByName(name), HttpStatus.OK);
    }
    @GetMapping("/books/{isbn}")
    public ResponseEntity<?> fetchBooksWithAuthorByIsbn(@PathVariable String isbn){
        return new ResponseEntity<>(bookstoreService.fetchBookWithAuthorByIsbn(isbn), HttpStatus.OK);
    }

    @GetMapping("/authors/innerjoin/{price}")
    public ResponseEntity<?> fetchAuthorsBooksByPriceInnerJoin(@PathVariable int price){
        return new ResponseEntity<>(bookstoreService.fetchAuthorsBooksByPriceInnerJoin(price),HttpStatus.OK);
    }

    @GetMapping("/authors/joinfetch/{price}")
    public ResponseEntity<?> fetchAuthorsBooksByPriceJoinFetch(@PathVariable int price){
        return new ResponseEntity<>(bookstoreService.fetchAuthorsBooksByPriceJoinFetch(price),HttpStatus.OK);
    }
    @GetMapping("/books")
    public ResponseEntity<?> fetchBooksAuthorsInnerJoinGood(){
        return new ResponseEntity<>(bookstoreService.fetchBooksAuthorsInnerJoinGood(),HttpStatus.OK);
    }


}
