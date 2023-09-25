package com.quangminh.slicesimplesql.controller;

import com.quangminh.slicesimplesql.service.BookstoreService;
import org.springframework.data.domain.Slice;
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
    @GetMapping("/{page}/{size}")
    public ResponseEntity<?> fetchAuthors(@PathVariable int page,
                                          @PathVariable int size){
        return new ResponseEntity<>(bookstoreService.fetchNextSlice(page, size), HttpStatus.OK);
    }
}
