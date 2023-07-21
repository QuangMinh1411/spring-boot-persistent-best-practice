package com.quangminh.attributelazyloadingbasic.controller;

import com.quangminh.attributelazyloadingbasic.entity.Author;
import com.quangminh.attributelazyloadingbasic.service.BookstoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/authors")
public class BookstoreController {
    private final BookstoreService service;

    @PostMapping
    public ResponseEntity<?> saveAuthor(@RequestPart(value = "body") Author author,
                                        @RequestPart("avatar")MultipartFile avatar) throws IOException {
        author.setAvatar(avatar.getBytes());
        service.createAuthor(author);
        return new ResponseEntity<>("Save author success", HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> fetchAuthorAge(@RequestParam("age") int age){
        return new ResponseEntity<>(service.fetchAuthorsByAgeGreaterThanEqual(age),HttpStatus.OK);
    }

    @GetMapping("/image/{id}")
    public ResponseEntity<?> getImage(@PathVariable Long id){
        Author author = service.fetchAuthorAvatarviaId(id);
        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(author.getAvatar());
    }

    @GetMapping("/detail")
    public ResponseEntity<?> getAuthorDetail(@RequestParam("age") int age){
        return new ResponseEntity<>(service.fetchAuthorsDetail(age),HttpStatus.OK);
    }
}
