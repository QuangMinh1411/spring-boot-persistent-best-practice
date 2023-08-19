package com.quangminh.mergecollection.controller;

import com.quangminh.mergecollection.entity.Book;
import com.quangminh.mergecollection.service.BookstoreService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class BookstoreController {

    private final BookstoreService bookstoreService;

    public BookstoreController(BookstoreService bookstoreService) {
        this.bookstoreService = bookstoreService;
    }

    @PostMapping("/{name}")
    public ResponseEntity<?> updateBooksOfAuthor(@PathVariable String name,
                                                 @RequestBody List<Book> books){
        return new ResponseEntity<>(bookstoreService.updateBooksOfAuthor(name,books), HttpStatus.OK);
    }
}
