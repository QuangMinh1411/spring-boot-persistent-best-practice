package com.quangminh.reuseprojection.controller;

import com.quangminh.reuseprojection.service.BookstoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authors")
public class BookstoreController {

    @Autowired
    private BookstoreService bookstoreService;

    @GetMapping
    public ResponseEntity<?> fetchAll(){
        return new ResponseEntity<>(bookstoreService.fetchAll(), HttpStatus.OK);
    }

    @GetMapping("/2")
    public ResponseEntity<?> fetchAgeNameGenre(){
        return new ResponseEntity<>(bookstoreService.fetchAgeNameGenre(), HttpStatus.OK);
    }

    @GetMapping("/3")
    public ResponseEntity<?> fetchNameEmail(){
        return new ResponseEntity<>(bookstoreService.fetchNameEmail(), HttpStatus.OK);
    }

    @GetMapping("/nameemail/{name}")
    public ResponseEntity<?> fetchAuthorByNameAsDtoNameEmailJpql(@PathVariable String name){
        return new ResponseEntity<>(bookstoreService.fetchAuthorByNameAsDtoNameEmailJpql(name), HttpStatus.OK);
    }

    @GetMapping("/nameemail/{name}/{age}")
    public ResponseEntity<?> fetchAuthorNameEmailDtoJpql(@PathVariable("name") String name,@PathVariable("age") int age){
        return new ResponseEntity<>(bookstoreService.fetchAuthorNameEmailDtoJpql(name,age), HttpStatus.OK);
    }

    @GetMapping("/genre/{genre}")
    public ResponseEntity<?> fetchAuthorGenreDtoJpa(@PathVariable String genre){
        return new ResponseEntity<>(bookstoreService.fetchAuthorGenreDtoJpa(genre), HttpStatus.OK);
    }

}
