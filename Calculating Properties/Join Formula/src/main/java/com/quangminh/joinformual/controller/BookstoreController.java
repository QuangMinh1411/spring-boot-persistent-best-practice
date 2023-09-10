package com.quangminh.joinformual.controller;

import com.quangminh.joinformual.service.BookstoreService;
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

    @GetMapping("/{id}/nextCheap")
    public ResponseEntity<?> fetchNextCheapBook(@PathVariable Long id){
        return new ResponseEntity<>(bookstoreService.fetchBook(id), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> fetchAllBookByAuthor(@PathVariable Long id){
        return new ResponseEntity<>(bookstoreService.fetchBooksFromAuthor(id),HttpStatus.OK);
    }
    @GetMapping("/{id}/cheapest")
    public ResponseEntity<?> fetchChepeastBook(@PathVariable Long id){
        return new ResponseEntity<>(bookstoreService.fetchCheapestBook(id),HttpStatus.OK);
    }
}
