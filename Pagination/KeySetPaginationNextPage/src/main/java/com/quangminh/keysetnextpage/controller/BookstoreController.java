package com.quangminh.keysetnextpage.controller;

import com.quangminh.keysetnextpage.service.BookstoreService;
import com.quangminh.keysetnextpage.view.AuthorView;
import com.quangminh.keysetnextpage.view.AuthorViewDto;
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

    @GetMapping("/{id}/{limit}")
    public AuthorView fetchAuthors(@PathVariable long id, @PathVariable int limit) {

        return bookstoreService.fetchNextPage(id, limit);
    }

    @GetMapping("/dto/{id}/{limit}")
    public AuthorViewDto fetchAuthorsDto(@PathVariable long id, @PathVariable int limit) {

        return bookstoreService.fetchNextPageDto(id, limit);
    }
}
