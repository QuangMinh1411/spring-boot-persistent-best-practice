package com.example.dtospringprojectionall.controller;

import com.example.dtospringprojectionall.service.BookstoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/authors")
public class BookstoreController {
    private final BookstoreService service;

    @GetMapping("/query/name")
    public ResponseEntity<?> fetchNameQuery(){
        return new ResponseEntity<>(service.fetchAuthorsName(), HttpStatus.OK);
    }

    @GetMapping("/query/nameage")
    public ResponseEntity<?> fetchNameAgeQuery(){
        return new ResponseEntity<>(service.fetchAuthorNamesAndAge(), HttpStatus.OK);
    }

    @GetMapping("/query/namenative")
    public ResponseEntity<?> fetchNameNativeQuery(){
        return new ResponseEntity<>(service.fetchAuthorsNameNative(), HttpStatus.OK);
    }

    @GetMapping("/query/nameagenative")
    public ResponseEntity<?> fetchNameAgeNativeQuery(){
        return new ResponseEntity<>(service.fetchAuthorNamesAndAgeNative(), HttpStatus.OK);
    }

    @GetMapping("/{genre}")
    public ResponseEntity<?> fetchNameAndAgeByGenre(@PathVariable String genre){
        return new ResponseEntity<>(service.fetchFirst2ByGenre(genre),HttpStatus.OK);
    }
}
