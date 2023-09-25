package com.quangminh.sliceviafetch.controller;

import com.quangminh.sliceviafetch.service.BookstoreService;
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

    @GetMapping("/{page}/{size}")
    public ResponseEntity<?> fetchNextSlice(@PathVariable int page,
                                            @PathVariable int size,
                                            @RequestParam("critical") String critical){
        return new ResponseEntity<>(bookstoreService.fetchNextSlice(page, size, critical), HttpStatus.OK);
    }
    @GetMapping("dto/{page}/{size}")
    public ResponseEntity<?> fetchNextSliceDto(@PathVariable int page,
                                            @PathVariable int size,
                                            @RequestParam("critical") String critical){
        return new ResponseEntity<>(bookstoreService.fetchNextSliceDto(page, size, critical), HttpStatus.OK);
    }

}
