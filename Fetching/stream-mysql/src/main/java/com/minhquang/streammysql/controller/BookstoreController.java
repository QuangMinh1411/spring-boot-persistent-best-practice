package com.minhquang.streammysql.controller;

import com.minhquang.streammysql.service.BookstoreService;
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

    @GetMapping("/streamAll")
    public ResponseEntity<?> streamAllAuthors(){
        return new ResponseEntity<>(bookstoreService.streamDatabase(), HttpStatus.OK);
    }

    @GetMapping("/genre-age/{genre}/{age}")
    public ResponseEntity<?> fetchAuthorsByGenreAndAgeGreaterThan(@PathVariable("genre") String genre,
                                                                  @PathVariable("age") int age){
        return new ResponseEntity<>(bookstoreService.fetchAuthorsByGenreAndAgeGreaterThan(genre,age),HttpStatus.OK);
    }

    @GetMapping("/books/{price}")
    public ResponseEntity<?> updateBookPrice(@PathVariable int price){
        return new ResponseEntity<>(bookstoreService.updateBookPrice(price),HttpStatus.OK);
    }

}
