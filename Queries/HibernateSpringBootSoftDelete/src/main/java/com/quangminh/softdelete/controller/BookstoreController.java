package com.quangminh.softdelete.controller;

import com.quangminh.softdelete.service.BookstoreService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class BookstoreController {

    private final BookstoreService bookstoreService;

    public BookstoreController(BookstoreService bookstoreService) {
        this.bookstoreService = bookstoreService;
    }
    @GetMapping("/authorsActive")
    public ResponseEntity<?> displayAllExceptDeletedAuthors(){
        return new ResponseEntity<>(bookstoreService.displayAllExceptDeletedAuthors(), HttpStatus.OK);
    }

    @GetMapping("/authorsAll")
    public ResponseEntity<?> displayAllIncludeDeletedAuthors(){
        return new ResponseEntity<>(bookstoreService.displayAllIncludeDeletedAuthors(), HttpStatus.OK);
    }

    @GetMapping("/authorsInActive")
    public ResponseEntity<?> displayAllOnlyDeletedAuthors(){
        return new ResponseEntity<>(bookstoreService.displayAllOnlyDeletedAuthors(), HttpStatus.OK);
    }

    @GetMapping("/booksActive")
    public ResponseEntity<?> displayAllExceptDeletedBooks(){
        return new ResponseEntity<>(bookstoreService.displayAllExceptDeletedBooks(), HttpStatus.OK);
    }

    @GetMapping("/booksAll")
    public ResponseEntity<?> displayAllIncludeDeletedBooks(){
        return new ResponseEntity<>(bookstoreService.displayAllIncludeDeletedBooks(), HttpStatus.OK);
    }

    @GetMapping("/booksInActive")
    public ResponseEntity<?> displayAllOnlyDeletedBooks(){
        return new ResponseEntity<>(bookstoreService.displayAllOnlyDeletedBooks(), HttpStatus.OK);
    }


    @DeleteMapping("/bookDelete/{authorId}/{bookIdx}")
    public ResponseEntity<?> softDeleteBook(@PathVariable long authorId,
                                            @PathVariable int bookIdx){
        bookstoreService.softDeleteBook(authorId,bookIdx);
        return new ResponseEntity<>("Delete ok",HttpStatus.OK);
    }

    @DeleteMapping("/authorDelete/{authorId}")
    public ResponseEntity<?> softDeleteAuthor(@PathVariable long authorId){
        bookstoreService.softDeleteAuthor(authorId);
        return new ResponseEntity<>("Delete ok",HttpStatus.OK);
    }

    @PutMapping("/restore/book/{bookId}")
    public ResponseEntity<?> restoreBook(@PathVariable long bookId){
        bookstoreService.restoreBook(bookId);
        return new ResponseEntity<>("Restore book success",HttpStatus.OK);
    }
    @PutMapping("/restore/author/{authorId}")
    public ResponseEntity<?> restoreAuthor(@PathVariable long authorId){
        bookstoreService.restoreAuthor(authorId);
        return new ResponseEntity<>("Restore author success",HttpStatus.OK);
    }
}
