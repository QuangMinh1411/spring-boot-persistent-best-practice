package com.quangminh.dtoentityviaprojectionnoassociation.controller;

import com.quangminh.dtoentityviaprojectionnoassociation.service.BookstoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authors")
public class BookstoreController {

    @Autowired
    private BookstoreService bookstoreService;

    @PostMapping
    public ResponseEntity<?> getAuthorAndUpdate(){
        return new ResponseEntity<>(bookstoreService.fetchAuthors(), HttpStatus.OK);
    }
}
