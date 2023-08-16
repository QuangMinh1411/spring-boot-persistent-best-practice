package com.quangminh.deleteorphanremoval.controller;

import com.quangminh.deleteorphanremoval.service.BookstoreService;
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

    @DeleteMapping
    public ResponseEntity<?> deleteAuthorsAndBooksViaDeleteAllInBatch(){
        return new ResponseEntity<>("DeleteAuthorandBooks in batch", HttpStatus.OK);
    }
    @DeleteMapping("/{age}")
    public ResponseEntity<?> deleteAuthorsAndBooksViaDeleteInBatch(@PathVariable("age") int age){
        bookstoreService.deleteAuthorsAndBooksViaDeleteInBatch(age);
        return new ResponseEntity<>("Delete via batch",HttpStatus.OK);
    }

    @DeleteMapping("/delete-all/{age}")
    public ResponseEntity<?> deleteAuthorsAndBooksViaDeleteAll(@PathVariable int age){
        bookstoreService.deleteAuthorsAndBooksViaDeleteAll(age);
        return new ResponseEntity<>("Delete all",HttpStatus.OK);
    }

    @DeleteMapping("/delete-orphan/{age}")
    public ResponseEntity<?> deleteAuthorsAndBooksViaDelete(@PathVariable int age){
        bookstoreService.deleteAuthorsAndBooksViaDelete(age);
        return new ResponseEntity<>("Delete via orphan removal",HttpStatus.OK);
    }
}
