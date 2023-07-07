package com.quangminh.namessubgraph.controller;

import com.quangminh.namessubgraph.service.BookstoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookstoreController {
    private final BookstoreService service;

    @GetMapping
    public ResponseEntity<?> displayAuthorsWithBookAndPublisher(){
        return new ResponseEntity<>(service.displayAuthorsWithBooksAndPublishers(), HttpStatus.OK);
    }


    @GetMapping("/age/{age}")
    public ResponseEntity<?> displayAuthorsByAgeWithBookAndPublisher(@PathVariable int age){
        return new ResponseEntity<>(service.displayAuthorsByAgeWithBooksAndPublishers(age), HttpStatus.OK);
    }

    @GetMapping("/age")
    public ResponseEntity<?> displayAuthorsByAgeWithBookAndPublisher(@RequestParam("low")int low,@RequestParam("high")int high){
        return new ResponseEntity<>(service.displayAuthorsByAgeWithBooksAndPublishers(low, high), HttpStatus.OK);
    }


    @GetMapping("/publishers")
    public ResponseEntity<?> displayPublisherwithBooksAndAuthor(){
        return new ResponseEntity<>(service.displayPublishersWithBooksAndAuthors(), HttpStatus.OK);
    }

    @GetMapping("/publishers/{id}")
    public ResponseEntity<?> displayPublishersByIdWithBooksAndAuthors(@PathVariable Long id){
        return new ResponseEntity<>(service.displayPublishersByIdWithBooksAndAuthors(id), HttpStatus.OK);
    }

    @GetMapping("/publishers/specs")
    public ResponseEntity<?> displayPublishersWithBooksAndAuthorsWithSpec(){
        return new ResponseEntity<>(service.displayPublishersWithBooksAndAuthorsWithSpec(), HttpStatus.OK);
    }
    @GetMapping("/publishers/id")
    public ResponseEntity<?> displayPublishersByIdBetween1And3WithBooksAndAuthors(@RequestParam("low") int low,@RequestParam("high") int high){
        return new ResponseEntity<>(service.displayPublishersByIdBetween1And3WithBooksAndAuthors(low, high), HttpStatus.OK);
    }

}
