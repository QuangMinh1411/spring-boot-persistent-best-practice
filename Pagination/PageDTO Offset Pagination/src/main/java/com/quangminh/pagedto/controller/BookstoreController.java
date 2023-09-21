package com.quangminh.pagedto.controller;

import com.quangminh.pagedto.dto.AuthorDto;
import com.quangminh.pagedto.service.BookstoreService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authors")
public class BookstoreController {

    private final BookstoreService bookstoreService;

    public BookstoreController(BookstoreService bookstoreService) {
        this.bookstoreService = bookstoreService;
    }
    @GetMapping("/{page}/{size}")
    public Page<AuthorDto> fetchAuthors(@PathVariable int page, @PathVariable int size,
                                        @RequestParam("critical") String critical) {

        return bookstoreService.fetchNextPage(page, size,critical);
    }
}
