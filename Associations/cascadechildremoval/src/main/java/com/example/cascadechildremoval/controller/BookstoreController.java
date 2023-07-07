package com.example.cascadechildremoval.controller;

import com.example.cascadechildremoval.service.BookstoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookstoreController {
    @Autowired
    private BookstoreService service;


    @GetMapping("/authors")
    public ResponseEntity<?> listAllAuthors(){
        return new ResponseEntity<>(service.getAllAuthor(), HttpStatus.OK);
    }

    @DeleteMapping("/authors/{name}")
    public ResponseEntity<?> deleteFromAuthorName(@PathVariable("name") String name){
        service.deleteViaIdentifier(name);
        return new ResponseEntity<>(service.getAllAuthor(),HttpStatus.OK);
    }

    @DeleteMapping("/authorsx/{name}")
    public ResponseEntity<?> deleteFromAuthorNameX(@PathVariable("name") String name){
        service.deleteViaIdentifierX(name);
        return new ResponseEntity<>(service.getAllAuthor(),HttpStatus.OK);
    }

    @DeleteMapping("/authorsage/{age}")
    public ResponseEntity<?> deleteFromAuthorAge(@PathVariable("age") int age){
        service.deleteViaBulkIn(age);
        return new ResponseEntity<>(service.getAllAuthor(),HttpStatus.OK);
    }

    @DeleteMapping("/authorsgenre/{genre}")
    public ResponseEntity<?> deleteFromAuthorGenre(@PathVariable("genre") String genre){
        service.deleteViaBulkInX(genre);
        return new ResponseEntity<>(service.getAllAuthor(),HttpStatus.OK);
    }

    @DeleteMapping("/authorsid/{id}")
    public ResponseEntity<?> deleteFromAuthorId(@PathVariable("id") Long id){
        service.deleteViaHardCodedIdentifier(id);
        return new ResponseEntity<>(service.getAllAuthor(),HttpStatus.OK);
    }

    @DeleteMapping("/authorsids")
    public ResponseEntity<?> deleteFromAuthorIdList(@RequestBody List<Long> ids){
        service.deleteViaBulkHardCodeIdentifier(ids);
        return new ResponseEntity<>(service.getAllAuthor(),HttpStatus.OK);
    }

}
