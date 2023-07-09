package com.quangminh.onetoonemapsid.controller;

import com.quangminh.onetoonemapsid.entity.Book;
import com.quangminh.onetoonemapsid.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookstoreController {
    private final BookService service;

    @PostMapping("/{authorId}")
    public ResponseEntity<?> saveBookWithAuthorId(@PathVariable("authorId") Long id, @RequestBody Book book){
        return new ResponseEntity<>(service.newBookOfAuthor(id,book), HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBooksOfAuthorId(@PathVariable Long id){
        return new ResponseEntity<>(service.fetchBookByAuthorId(id),HttpStatus.OK);
    }
}
