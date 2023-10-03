package com.quangminh.fetchjoinqueries.controller;

import com.quangminh.fetchjoinqueries.service.BookstoreService;
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
    public ResponseEntity<?> displayBookById(@PathVariable long id){
        return new ResponseEntity<>(bookstoreService.displayBookById(id), HttpStatus.OK);
    }

    @GetMapping("/join-fetch/{id}")
    public ResponseEntity<?> displayBookByIdViaJoinFetch(@PathVariable long id){
        return new ResponseEntity<>(bookstoreService.displayBookByIdViaJoinFetch(id), HttpStatus.OK);
    }

    @GetMapping("/entity-graph/{id}")
    public ResponseEntity<?> displayBookByIdViaEntityGraph(@PathVariable long id){
        return new ResponseEntity<>(bookstoreService.displayBookByIdViaEntityGraph(id), HttpStatus.OK);
    }

    @GetMapping("/list/entityGraph")
    public ResponseEntity<?> displayBooksViaEntityGraph(){
        return new ResponseEntity<>(bookstoreService.displayBooksViaEntityGraph(),HttpStatus.OK);
    }

    @GetMapping("/list/entityGraphGT35")
    public ResponseEntity<?> displayBooksByAgeGt45ViaEntityGraph(){
        return new ResponseEntity<>(bookstoreService.displayBooksByAgeGt45ViaEntityGraph(),HttpStatus.OK);
    }

    @GetMapping("/list/joinfetch")
    public ResponseEntity<?> displayBooksViaJoinFetch(){
        return new ResponseEntity<>(bookstoreService.displayBooksViaJoinFetch(),HttpStatus.OK);
    }

}
