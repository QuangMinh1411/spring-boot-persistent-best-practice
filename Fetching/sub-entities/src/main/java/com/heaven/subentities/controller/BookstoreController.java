package com.heaven.subentities.controller;

import com.heaven.subentities.entity.AuthorDeep;
import com.heaven.subentities.service.BookstoreService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/authors")
public class BookstoreController {
    private final BookstoreService service;

    public BookstoreController(BookstoreService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> saveAuthor(@RequestPart(value = "body") AuthorDeep author,
                                        @RequestPart("avatar") MultipartFile avatar) throws IOException {
        author.setAvatar(avatar.getBytes());
        service.createAuthor(author);
        return new ResponseEntity<>("Save author success", HttpStatus.CREATED);
    }

    @GetMapping("/shallow")
    public ResponseEntity<?> fetchAuthorsShallow(){
        return new ResponseEntity<>(service.fetchAuthorsShallow(),HttpStatus.OK);
    }

    @GetMapping("/deep")
    public ResponseEntity<?> fetchAuthorsDeep(){
        return new ResponseEntity<>(service.fetchAuthorDeep(),HttpStatus.OK);
    }

}
