package com.quangminh.resulttransformer.controller;

import com.quangminh.resulttransformer.service.BookstoreService;
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

    @GetMapping("/setter")
    public ResponseEntity<?> getAuthorWithSetter(){
        return new ResponseEntity<>(bookstoreService.fetchAuthorsWithSetters(), HttpStatus.OK);

    }

    @GetMapping("/no-setter")
    public ResponseEntity<?> getAuthorWithoutSetter(){
        return new ResponseEntity<>(bookstoreService.fetchAuthorsNoSetters(), HttpStatus.OK);

    }
}
