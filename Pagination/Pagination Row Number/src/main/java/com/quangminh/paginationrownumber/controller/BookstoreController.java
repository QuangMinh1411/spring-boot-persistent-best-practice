package com.quangminh.paginationrownumber.controller;

import com.quangminh.paginationrownumber.service.BookstoreService;
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
    @GetMapping("/{start}/{end}")
    public ResponseEntity<?> fetchAuthors(@PathVariable int start,
                                          @PathVariable int end){
        return new ResponseEntity<>(bookstoreService.fetchNextPage(start, end), HttpStatus.OK);
    }
}
