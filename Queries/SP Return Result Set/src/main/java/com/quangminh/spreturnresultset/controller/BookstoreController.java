package com.quangminh.spreturnresultset.controller;

import com.quangminh.spreturnresultset.service.BookstoreService;
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

    @GetMapping("/name-age-1/{genre}")
    public ResponseEntity<?> fetchAnthologyAuthorsViaNamedStoredProcedure(@PathVariable String genre) {
        return new ResponseEntity<>(bookstoreService.fetchAnthologyAuthorsViaNamedStoredProcedure(genre), HttpStatus.OK);
    }

    @GetMapping("/name-age-2/{genre}")
    public ResponseEntity<?> fetchAnthologyAuthorsViaStoredProcedure(@PathVariable String genre) {
        return new ResponseEntity<>(bookstoreService.fetchAnthologyAuthorsViaStoredProcedure(genre), HttpStatus.OK);
    }

    @GetMapping("/name-age-3/{genre}")
    public ResponseEntity<?> fetchAnthologyDtoAuthorsViaStoredProcedure(@PathVariable String genre) {
        return new ResponseEntity<>(bookstoreService.fetchAnthologyDtoAuthorsViaStoredProcedure(genre), HttpStatus.OK);
    }

    @GetMapping("/name-age-4/{genre}")
    public ResponseEntity<?> fetchAnthologyManualMappingDtoAuthorsViaStoredProcedure(@PathVariable String genre) {
        return new ResponseEntity<>(bookstoreService.fetchAnthologyManualMappingDtoAuthorsViaStoredProcedure(genre), HttpStatus.OK);
    }
}
