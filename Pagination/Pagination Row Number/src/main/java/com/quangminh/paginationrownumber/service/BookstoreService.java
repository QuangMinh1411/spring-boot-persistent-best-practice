package com.quangminh.paginationrownumber.service;

import com.quangminh.paginationrownumber.dto.AuthorDto;
import com.quangminh.paginationrownumber.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookstoreService {

    private final AuthorRepository authorRepository;

    public BookstoreService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }
    public List<AuthorDto> fetchNextPage(int start, int end) {

        List<AuthorDto> authors = authorRepository.fetchPage(start, end);

        return authors;
    }
}
