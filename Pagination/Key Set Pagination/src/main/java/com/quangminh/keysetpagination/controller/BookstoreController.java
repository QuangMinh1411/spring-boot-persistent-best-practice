package com.quangminh.keysetpagination.controller;

import com.quangminh.keysetpagination.AuthorDto;
import com.quangminh.keysetpagination.entity.Author;
import com.quangminh.keysetpagination.service.BookstoreService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class BookstoreController {

    private final BookstoreService bookstoreService;

    public BookstoreController(BookstoreService bookstoreService) {
        this.bookstoreService = bookstoreService;
    }
    @GetMapping("/{id}/{limit}")
    public List<Author> fetchAuthors(@PathVariable long id, @PathVariable int limit) {

        return bookstoreService.fetchNextPage(id, limit);
    }

    @GetMapping("/dto/{id}/{limit}")
    public List<AuthorDto> fetchAuthorsDto(@PathVariable long id, @PathVariable int limit) {

        return bookstoreService.fetchNextPageDto(id, limit);
    }
}
