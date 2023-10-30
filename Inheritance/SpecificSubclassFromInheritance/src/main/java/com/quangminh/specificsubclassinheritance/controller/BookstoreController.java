package com.quangminh.specificsubclassinheritance.controller;

import com.quangminh.specificsubclassinheritance.service.BookstoreService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookstoreController {

    private final BookstoreService bookstoreService;

    public BookstoreController(BookstoreService bookstoreService) {
        this.bookstoreService = bookstoreService;
    }
    @GetMapping("/authorName/ebookrepo/{name}")
    public ResponseEntity<?> findEbookByAuthorNameViaEbookRepository(@PathVariable String name){
        return new ResponseEntity<>(bookstoreService.findEbookByAuthorNameViaEbookRepository(name), HttpStatus.OK);
    }

    @GetMapping("/authorName/bookrepo/{name}")
    public ResponseEntity<?> findEbookByAuthorNameViaBookRepository(@PathVariable String name){
        return new ResponseEntity<>(bookstoreService.findEbookByAuthorNameViaBookRepository(name), HttpStatus.OK);
    }
}
