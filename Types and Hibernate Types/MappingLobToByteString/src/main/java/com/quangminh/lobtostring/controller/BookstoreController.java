package com.quangminh.lobtostring.controller;

import com.quangminh.lobtostring.service.BookstoreService;
import jakarta.annotation.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authors")
public class BookstoreController {

    private final BookstoreService bookstoreService;

    public BookstoreController(BookstoreService bookstoreService) {
        this.bookstoreService = bookstoreService;
    }
    @GetMapping("/image/{name}")
    public ResponseEntity<?> getImage(@PathVariable String name){
        byte[] file = bookstoreService.displayAuthorImg(name);
        return ResponseEntity.ok()
                .body(file);
    }
}
