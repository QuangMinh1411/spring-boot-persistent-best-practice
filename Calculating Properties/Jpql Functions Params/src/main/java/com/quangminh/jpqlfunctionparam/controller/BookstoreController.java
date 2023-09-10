package com.quangminh.jpqlfunctionparam.controller;

import com.quangminh.jpqlfunctionparam.entity.Book;
import com.quangminh.jpqlfunctionparam.service.BookstoreService;
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
    @GetMapping("/{id}")
    public ResponseEntity<?> fetchBookTitleAndPriceById(@PathVariable Long id){
        return new ResponseEntity<>(bookstoreService.titleAndPrice(id), HttpStatus.OK);
    }
}
