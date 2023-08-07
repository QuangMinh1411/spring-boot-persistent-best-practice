package com.minhquang.dtoviacrossjoin.controller;

import com.minhquang.dtoviacrossjoin.repository.BookRepository;
import com.minhquang.dtoviacrossjoin.repository.FormatRepository;
import com.minhquang.dtoviacrossjoin.service.BookstoreService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class BookstoreController {


    private final BookstoreService bookstoreService;

    public BookstoreController(BookstoreService bookstoreService) {
        this.bookstoreService = bookstoreService;
    }

    @GetMapping("/books")
    public ResponseEntity<?> fetchBooksAndFormatsJpql(){
        return new ResponseEntity<>(bookstoreService.fetchBooksAndFormatsJpql(), HttpStatus.OK);
    }
    @GetMapping("/format")
    public ResponseEntity<?> fetchFormatsAndBooksJpql(){
        return new ResponseEntity<>(bookstoreService.fetchFormatsAndBooksJpql(), HttpStatus.OK);
    }

}
