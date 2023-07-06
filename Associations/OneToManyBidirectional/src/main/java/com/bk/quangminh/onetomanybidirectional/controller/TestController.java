package com.bk.quangminh.onetomanybidirectional.controller;

import com.bk.quangminh.onetomanybidirectional.entity.Book;
import com.bk.quangminh.onetomanybidirectional.service.BookstoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class TestController {
    private final BookstoreService service;

    @PostMapping("/insert")
    public ResponseEntity<?> insertBookWithAuthor(@RequestBody Book book, @RequestParam Long id){
        service.insertAuthorWithBooks(id,book);
        return new ResponseEntity<>("Insert success", HttpStatus.CREATED);
    }

    @GetMapping("/{name}")
    public ResponseEntity<?> getBooksFromAuthor(@PathVariable String name){
        return new ResponseEntity<>(service.findBooksByAuthor(name),HttpStatus.OK);
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<?> deleteBooksFromAuthor(@PathVariable String name){
        service.deleteBookOfAuthor(name);
        return new ResponseEntity<>("Delete success",HttpStatus.OK);
    }
}
