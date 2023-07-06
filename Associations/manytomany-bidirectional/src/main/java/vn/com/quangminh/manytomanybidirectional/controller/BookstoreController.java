package vn.com.quangminh.manytomanybidirectional.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.com.quangminh.manytomanybidirectional.entity.Author;
import vn.com.quangminh.manytomanybidirectional.entity.Book;
import vn.com.quangminh.manytomanybidirectional.service.BookstoreService;

@RestController
@RequestMapping("/authors")
@RequiredArgsConstructor
public class BookstoreController {
    private final BookstoreService service;

    @PostMapping
    public ResponseEntity<?> saveAuthor(@RequestBody Author author){
        return new ResponseEntity<>(service.createAuthor(author), HttpStatus.CREATED);
    }

    @PostMapping("/{id}")
    public ResponseEntity<?> insertBookWithAuthor(@PathVariable Long id, @RequestBody Book book){
        service.insertAuthorsWithBooks(id,book);
        return new ResponseEntity<>("Book inserted",HttpStatus.CREATED);
    }
}
