package com.quangminh.mapbooleanyesno.controller;

import com.quangminh.mapbooleanyesno.entity.Author;
import com.quangminh.mapbooleanyesno.service.BookstoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class AuthorController {
    private final BookstoreService service;

    @PostMapping
    public ResponseEntity<?> saveAuthor(@RequestBody Author author){
        return new ResponseEntity<>(service.persistAuthor(author), HttpStatus.CREATED);
    }

    @GetMapping("/{name}")
    public ResponseEntity<?> getByname(@PathVariable String name){
        return new ResponseEntity<>(service.fechAuthor(name),HttpStatus.OK);
    }

}
