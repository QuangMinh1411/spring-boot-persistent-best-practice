package com.example.dtoviaprojectioninterfaceinrepo.controller;

import com.example.dtoviaprojectioninterfaceinrepo.service.BookstoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authors")
@RequiredArgsConstructor
public class BookstoreController  {
    private final BookstoreService service;

    @GetMapping("/{genre}")
    public ResponseEntity<?> fechFirstByGenre(@PathVariable String genre){
        return new ResponseEntity<>(service.fetchFirst2ByBirthplace(genre), HttpStatus.OK);
    }
}
