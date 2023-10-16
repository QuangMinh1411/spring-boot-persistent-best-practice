package com.quangminh.storeprocedurejdbc.controller;

import com.quangminh.storeprocedurejdbc.service.BookstoreService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authors")
public class BookStoreController {

    private final BookstoreService bookstoreService;

    public BookStoreController(BookstoreService bookstoreService) {
        this.bookstoreService = bookstoreService;
    }
    @GetMapping("/{genre}")
    public ResponseEntity<?> fetchNicknameAndAgeByGenre(@PathVariable String genre){
        return new ResponseEntity<>(bookstoreService.fetchNicknameAndAgeByGenre(genre), HttpStatus.OK);
    }

    @GetMapping("/jdbc/{genre}")
    public ResponseEntity<?> fetchAnthologyAuthors(@PathVariable String genre){
        return new ResponseEntity<>(bookstoreService.fetchAnthologyAuthors(genre), HttpStatus.OK);
    }

    @GetMapping("/jdbc-id/{id}")
    public ResponseEntity<?> fetchNicknameAndAgeById(@PathVariable Long id){
        return new ResponseEntity<>(bookstoreService.fetchNicknameAndAgeById(id), HttpStatus.OK);
    }

}
