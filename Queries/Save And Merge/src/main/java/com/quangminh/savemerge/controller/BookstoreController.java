package com.quangminh.savemerge.controller;

import com.quangminh.savemerge.entity.Author;
import com.quangminh.savemerge.service.BookstoreService;
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

    @PutMapping("/{id}")
    public ResponseEntity<?> updateAuthorViaMerge(@PathVariable long id){
        Author author1 = bookstoreService.fetchAuthorById(id);
        author1.setAge(author1.getAge()+1);
        bookstoreService.updateAuthorViaMerge(author1);
        return new ResponseEntity<>(author1, HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateAuthorViaUpdate(@PathVariable long id){
        Author author = bookstoreService.fetchAuthorById(id);
        author.setAge(author.getAge()+1);
        bookstoreService.updateAuthorViaUpdate(author);
        return new ResponseEntity<>(author,HttpStatus.OK);
    }
}
