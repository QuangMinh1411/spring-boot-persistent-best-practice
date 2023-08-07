package com.minhquang.joinpagination.controller;

import com.minhquang.joinpagination.dto.AuthorBookDto;
import com.minhquang.joinpagination.service.BookstoreService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Slice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookstoreController {

    private final BookstoreService bookstoreService;

    public BookstoreController(BookstoreService bookstoreService) {
        this.bookstoreService = bookstoreService;
    }

    @GetMapping("/page/{page}/{size}")
    public Page<AuthorBookDto> fetchPageOfAuthorsWithBooksDtoByGenre(
            @PathVariable int page, @PathVariable int size, @RequestParam("genre")String genre) {

        return bookstoreService.fetchPageOfAuthorsWithBooksDtoByGenre(genre,page, size);
    }

    @GetMapping("/slice/{page}/{size}")
    public Slice<AuthorBookDto> fetchSliceOfAuthorsWithBooksDtoByGenre(
            @PathVariable int page, @PathVariable int size,@RequestParam("genre")String genre) {

        return bookstoreService.fetchSliceOfAuthorsWithBooksDtoByGenre(genre,page, size);
    }

    @GetMapping("/list/{page}/{size}")
    public List<AuthorBookDto> fetchListOfAuthorsWithBooksDtoByGenre(
            @PathVariable int page, @PathVariable int size,@RequestParam("genre")String genre) {

        return bookstoreService.fetchListOfAuthorsWithBooksDtoByGenre(genre,page, size);
    }

    @GetMapping("/page/native/{page}/{size}")
    public Page<AuthorBookDto> fetchPageOfAuthorsWithBooksDtoByGenreNative(
            @PathVariable int page, @PathVariable int size,@RequestParam("genre")String genre) {

        return bookstoreService.fetchPageOfAuthorsWithBooksDtoByGenreNative(genre,page, size);
    }

    @GetMapping("/page/dr/{page}/{size}")
    public List<AuthorBookDto> fetchListOfAuthorsWithBooksDtoNativeDenseRank(
            @PathVariable int page, @PathVariable int size,@RequestParam("genre")String genre) {

        return bookstoreService.fetchListOfAuthorsWithBooksDtoNativeDenseRank(genre,page, size);
    }
}
