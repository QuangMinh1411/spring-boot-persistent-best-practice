package com.quangminh.joinfetchrepair.controller;

import com.quangminh.joinfetchrepair.service.BookstoreService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authors")
public class BookstoreController {

    private final BookstoreService bookstoreService;

    public BookstoreController(BookstoreService bookstoreService) {
        this.bookstoreService = bookstoreService;
    }
    @GetMapping("/{genre}/{page}/{size}")
    public ResponseEntity<?> fetchPageOfAuthorsWithBooksByGenre(@PathVariable("genre") String genre,
                                                                @PathVariable("page") int page,
                                                                @PathVariable("size") int size){
        return new ResponseEntity<>(bookstoreService.fetchPageOfAuthorsWithBooksByGenre(genre, page, size), HttpStatus.OK);
    }

    @GetMapping("/slice/{genre}/{page}/{size}")
    public ResponseEntity<?> fetchSliceOfAuthorsWithBooksByGenre(@PathVariable String genre,
                                                                @PathVariable int page,
                                                                @PathVariable int size){
        return new ResponseEntity<>(bookstoreService.fetchSliceOfAuthorsWithBooksByGenre(genre, page, size), HttpStatus.OK);
    }

    @GetMapping("/list/{genre}/{page}/{size}")
    public ResponseEntity<?> fetchListOfAuthorsWithBooksByGenre(@PathVariable String genre,
                                                                 @PathVariable int page,
                                                                 @PathVariable int size){
        return new ResponseEntity<>(bookstoreService.fetchListOfAuthorsWithBooksByGenre(genre, page, size), HttpStatus.OK);
    }

    @GetMapping("/eg/{genre}/{page}/{size}")
    public ResponseEntity<?> fetchPageOfAuthorsWithBooksByGenreEntityGraph(@PathVariable String genre,
                                                                @PathVariable int page,
                                                                @PathVariable int size){
        return new ResponseEntity<>(bookstoreService.fetchPageOfAuthorsWithBooksByGenreEntityGraph(genre, page, size), HttpStatus.OK);
    }

    @GetMapping("/tuple/{genre}/{page}/{size}")
    public ResponseEntity<?> fetchPageOfAuthorsWithBooksByGenreTuple(@PathVariable String genre,
                                                                           @PathVariable int page,
                                                                           @PathVariable int size){
        return new ResponseEntity<>(bookstoreService.fetchPageOfAuthorsWithBooksByGenreTuple(genre, page, size), HttpStatus.OK);
    }


}
