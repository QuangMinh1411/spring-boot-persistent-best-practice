package com.quangminh.specqueryfetchjoin.controller;

import com.quangminh.specqueryfetchjoin.service.BookstoreService;
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

    @GetMapping("/join-fetch-spec/{genre}")
    public ResponseEntity<?> fetchViaJoinFetchSpecification(@PathVariable String genre,
                                                            @RequestParam("page") int page,
                                                            @RequestParam("size") int size){
        return new ResponseEntity<>(bookstoreService.fetchViaJoinFetchSpecification(page, size, genre), HttpStatus.OK);
    }

    @GetMapping("/join-fetch-id-spec/{genre}")
    public ResponseEntity<?> fetchViaJoinFetchInIdsSpecification(@PathVariable String genre,
                                                            @RequestParam("page") int page,
                                                            @RequestParam("size") int size){
        return new ResponseEntity<>(bookstoreService.fetchViaJoinFetchInIdsSpecification(page, size, genre), HttpStatus.OK);
    }
}
