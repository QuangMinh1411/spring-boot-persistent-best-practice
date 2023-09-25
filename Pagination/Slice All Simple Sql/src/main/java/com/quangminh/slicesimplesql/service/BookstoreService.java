package com.quangminh.slicesimplesql.service;

import com.quangminh.slicesimplesql.entity.Author;
import com.quangminh.slicesimplesql.repository.AuthorRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

@Service
public class BookstoreService {
    private final AuthorRepository authorRepository;

    public BookstoreService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Slice<Author> fetchNextSlice(int page, int size) {

        return authorRepository.findAll(PageRequest.of(page, size));
    }
}
