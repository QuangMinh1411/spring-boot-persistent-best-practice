package com.quangminh.attributelazyloadingbasic.controller;

import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.quangminh.attributelazyloadingbasic.entity.Author;
import com.quangminh.attributelazyloadingbasic.service.BookstoreService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController

@RequestMapping("/authors")
public class BookstoreController {
    private final BookstoreService service;
    private final SimpleFilterProvider filterProvider;

    public BookstoreController(BookstoreService service) {
        this.service = service;
        filterProvider = new SimpleFilterProvider().addFilter("AuthorId",
                SimpleBeanPropertyFilter.filterOutAllExcept("id","name","age","genre"));
        filterProvider.setFailOnUnknownId(false);
    }

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

    @GetMapping("/{age}")
    public MappingJacksonValue fetchAuthorByAgeGreaterThanEqual(@PathVariable int age){
        List<Author> authors = service.fetchAuthorsByAgeGreaterThanEqual(age);
        MappingJacksonValue wrapper = new MappingJacksonValue(authors);
        wrapper.setFilters(filterProvider);
        return wrapper;
    }
}
