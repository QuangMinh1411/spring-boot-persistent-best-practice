package com.quangminh.dtoentityviaprojection.controller;

import com.quangminh.dtoentityviaprojection.entity.Author;
import com.quangminh.dtoentityviaprojection.service.BookstoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authors")
public class BookstoreController {

    @Autowired
    private BookstoreService bookstoreService;

    @GetMapping
    public ResponseEntity<?> fetchPaging(@RequestParam("page") int page,
                                         @RequestParam("size") int size){
        return new ResponseEntity<>(bookstoreService.fetchAuthorsPaging(page,size), HttpStatus.OK);
    }

    @PostMapping("/{index}")
    public ResponseEntity<?> fetchAndPost(@RequestBody Author author,@PathVariable int index){
        return new ResponseEntity<>(bookstoreService.fetchAuthors(index,author),HttpStatus.OK);
    }
}
