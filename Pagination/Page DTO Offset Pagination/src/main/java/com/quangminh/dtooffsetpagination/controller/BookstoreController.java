package com.quangminh.dtooffsetpagination.controller;

import com.quangminh.dtooffsetpagination.dto.AuthorDto;
import com.quangminh.dtooffsetpagination.service.BookstoreService;
import org.apache.coyote.Response;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
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
    @GetMapping("/native/{page}/{size}")
    public Page<AuthorDto> fetchAuthorsNative(@PathVariable int page, @PathVariable int size) {

        return bookstoreService.fetchNextPageNative(page, size);
    }

    @GetMapping("/jpql/{page}/{size}")
    public Page<AuthorDto> fetchAuthorsJpql(@PathVariable int page, @PathVariable int size) {

        return bookstoreService.fetchNextPageJpql(page, size);
    }

    @GetMapping("/nativelist/{page}/{size}")
    public ResponseEntity<?> fetchAuthorsNativeList(@PathVariable int page, @PathVariable int size) {

        return new ResponseEntity<>(bookstoreService.fetchNextPageNativeList(page, size), HttpStatus.OK);
    }


    @GetMapping("/jpqllist/{page}/{size}")
    public ResponseEntity<?> fetchAuthorsJpqlList(@PathVariable int page, @PathVariable int size) {

        return new ResponseEntity<>(bookstoreService.fetchNextPageJpqlList(page, size), HttpStatus.OK);
    }

}
