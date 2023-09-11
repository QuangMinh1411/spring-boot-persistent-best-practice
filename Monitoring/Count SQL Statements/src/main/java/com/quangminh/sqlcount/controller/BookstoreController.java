package com.quangminh.sqlcount.controller;

import com.quangminh.sqlcount.service.BookstoreService;
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
    @PatchMapping("/update")
    public ResponseEntity<?> updateWithoutTransaction(@RequestParam("id")String id,
                                                      @RequestParam("genre")String genre){
        return new ResponseEntity<>(bookstoreService.updateAuthorWithoutTransactional(Long.valueOf(id),genre), HttpStatus.CREATED);
    }
    @PatchMapping("/update-transactional")
    public ResponseEntity<?> updateWithTransaction(@RequestParam("id")String id,
                                                      @RequestParam("genre")String genre){
        return new ResponseEntity<>(bookstoreService.updateAuthorWithTransactional(Long.valueOf(id),genre), HttpStatus.CREATED);
    }
}
