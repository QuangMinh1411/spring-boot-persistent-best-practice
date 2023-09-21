package com.quangminh.offsetpagination.service;

import com.quangminh.offsetpagination.entity.Author;
import com.quangminh.offsetpagination.repository.AuthorRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class BookstoreService {

    private final AuthorRepository authorRepository;

    public BookstoreService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Page<Author> fetchNextPage(int page, int size,String critial) {

        return authorRepository.findAll(PageRequest.of(page, size,
                Sort.by(Sort.Direction.ASC, critial)));
    }

    public Page<Author> fetchNextPageByGenre(int page, int size,String genre,String critial) {

        return authorRepository.fetchByGenre(genre,
                PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, critial)));
    }

    public Page<Author> fetchNextPageByGenreExplicitCount(int page, int size,String genre,String critial) {

        return authorRepository.fetchByGenreExplicitCount(genre,
                PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, critial)));
    }

    public Page<Author> fetchNextPageByGenreNative(int page, int size,String genre,String critial) {

        return authorRepository.fetchByGenreNative(genre,
                PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, critial)));
    }

    public Page<Author> fetchNextPageByGenreNativeExplicitCount(int page, int size,String genre,String critial) {

        return authorRepository.fetchByGenreNativeExplicitCount(genre,
                PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, critial)));
    }

    public Page<Author> fetchNextPagePageable(Pageable pageable) {

        return authorRepository.findAll(pageable);
    }
}
