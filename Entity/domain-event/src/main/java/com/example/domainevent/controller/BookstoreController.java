package com.example.domainevent.controller;

import com.example.domainevent.entity.Book;
import com.example.domainevent.entity.BookReview;
import com.example.domainevent.service.BookstoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookstoreController {
    private final BookstoreService service;

    @PostMapping
    public ResponseEntity<?> insertBook(@RequestBody Book book){
        return new ResponseEntity<>(service.insertBook(book),HttpStatus.CREATED);
    }

    @PostMapping("/{id}/review")
    public ResponseEntity<?> postReview(@PathVariable Long id, @RequestBody BookReview review){
        return new ResponseEntity<>(service.postReview(id,review),HttpStatus.CREATED);
    }
}
