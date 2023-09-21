package com.quangminh.offsetpagination.controller;

import com.quangminh.offsetpagination.service.BookstoreService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authors")
public class BookstoreController {

    private final BookstoreService bookstoreService;

    public BookstoreController(BookstoreService bookstoreService) {
        this.bookstoreService = bookstoreService;
    }

    @GetMapping("/authorsByGenre/{page}/{size}")
    public ResponseEntity<?> fetchAuthorsByGenre(@PathVariable int page, @PathVariable int size,
                                                 @RequestParam("critial") String critial){
        return new ResponseEntity<>(bookstoreService.fetchNextPage(page,size,critial), HttpStatus.OK);
    }


    @GetMapping("/authorsByGenreExplicitCount/{page}/{size}")
    public ResponseEntity<?> fetchAuthorsByGenreExplicitCount(@PathVariable int page, @PathVariable int size,
                                                              @RequestParam("genre") String genre,
                                                              @RequestParam("critical") String critial) {
        return new ResponseEntity<>(bookstoreService.fetchNextPageByGenreExplicitCount(page,size,genre,critial), HttpStatus.OK);

    }

    @GetMapping("/authorsByGenreNative/{page}/{size}")
    public ResponseEntity<?> fetchAuthorsByGenreNative(@PathVariable int page, @PathVariable int size,
                                                       @RequestParam("genre") String genre,
                                                       @RequestParam("critical") String critial) {

        return new ResponseEntity<>(bookstoreService.fetchNextPageByGenreNative(page,size,genre,critial), HttpStatus.OK);
    }


    @GetMapping("/authorsByGenreNativeExplicitCount/{page}/{size}")
    public ResponseEntity<?> fetchAuthorsByGenreNativeExplicitCount(@PathVariable int page, @PathVariable int size,
                                                                    @RequestParam("genre") String genre,
                                                                    @RequestParam("critical") String critial) {
        return new ResponseEntity<>(bookstoreService.fetchNextPageByGenreNativeExplicitCount(page,size,genre,critial), HttpStatus.OK);

    }

    @GetMapping
    // Request example: http://localhost:8080/authors?page=1&size=3&sort=name,desc
    public ResponseEntity<?> fetchAuthors(Pageable pageable) {

       return new ResponseEntity<>(bookstoreService.fetchNextPagePageable(pageable),HttpStatus.OK);
    }


}
