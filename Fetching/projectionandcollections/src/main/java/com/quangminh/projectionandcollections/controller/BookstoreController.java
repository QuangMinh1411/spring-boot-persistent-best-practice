package com.quangminh.projectionandcollections.controller;

import com.quangminh.projectionandcollections.service.BookstoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authors")
public class BookstoreController {


    @Autowired
    private BookstoreService bookstoreService;

    @GetMapping("/1")
    public ResponseEntity<?> fetchAuthorsWithBooksQueryBuilderMechanism(){
        return new ResponseEntity<>(bookstoreService.fetchAuthorsWithBooksQueryBuilderMechanism(), HttpStatus.OK);
    }

    @GetMapping("/2")
    public ResponseEntity<?> fetchAuthorsWithBooksViaQuery(){
        return new ResponseEntity<>(bookstoreService.fetchAuthorsWithBooksViaQuery(), HttpStatus.OK);
    }
    @GetMapping("/3")
    public ResponseEntity<?> fetchAuthorsWithBooksViaJoinFetch(){
        return new ResponseEntity<>(bookstoreService.fetchAuthorsWithBooksViaJoinFetch(), HttpStatus.OK);
    }

    @GetMapping("/4")
    public ResponseEntity<?> fetchAuthorsWithBooksViaQuerySimpleDto(){
        return new ResponseEntity<>(bookstoreService.fetchAuthorsWithBooksViaQuerySimpleDto(), HttpStatus.OK);
    }

    @GetMapping("/5")
    public ResponseEntity<?> fetchAuthorsWithBooksViaArrayOfObjects(){
        return new ResponseEntity<>(bookstoreService.fetchAuthorsWithBooksViaArrayOfObjects(), HttpStatus.OK);
    }

}
