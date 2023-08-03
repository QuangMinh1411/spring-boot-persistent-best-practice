package com.quangminh.dtosetmappingandnamenativequery.controller;

import com.quangminh.dtosetmappingandnamenativequery.service.BookstoreService;
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

    @GetMapping("/name-age")
    public ResponseEntity<?> fetchNameAndAge(){
        return new ResponseEntity<>(bookstoreService.fetchAuthorsNameAndAge(), HttpStatus.OK);
    }
    @GetMapping("/name")
    public ResponseEntity<?> fetchName(){
        return new ResponseEntity<>(bookstoreService.fetchAuthorName(), HttpStatus.OK);
    }
    @GetMapping("/name-age/xml")
    public ResponseEntity<?> fetchNameAndAgeXml(){
        return new ResponseEntity<>(bookstoreService.fetchNameAndAgeXml(), HttpStatus.OK);
    }

    @GetMapping("/dao")
    public ResponseEntity<?> fetchDao(){
        return new ResponseEntity<>(bookstoreService.fetchAuthorByEntity(),HttpStatus.OK);
    }
}
