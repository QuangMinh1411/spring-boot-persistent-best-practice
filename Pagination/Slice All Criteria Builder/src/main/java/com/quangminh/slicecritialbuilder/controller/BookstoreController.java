package com.quangminh.slicecritialbuilder.controller;

import com.quangminh.slicecritialbuilder.entity.Author;
import com.quangminh.slicecritialbuilder.service.BookstoreService;
import org.springframework.data.domain.Slice;
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

    @GetMapping("/{page}/{size}")
    public Slice<Author> fetchAuthors(@PathVariable int page, @PathVariable int size) {

        return bookstoreService.fetchNextSlice(page, size);
    }
}
