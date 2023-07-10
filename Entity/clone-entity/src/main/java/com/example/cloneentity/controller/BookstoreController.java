package com.example.cloneentity.controller;

import com.example.cloneentity.service.BookstoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookstoreController {
    private final BookstoreService service;

    @PostMapping("/clone")
    public ResponseEntity<?> cloneAuthor(@RequestParam("name")String name,@RequestParam("age") int age,
                                         @RequestParam("aname") String aname,@RequestParam("isClone") boolean isClone){
        return new ResponseEntity<>(service.cloneAuthor(name,age,aname,isClone), HttpStatus.CREATED);
    }
}
