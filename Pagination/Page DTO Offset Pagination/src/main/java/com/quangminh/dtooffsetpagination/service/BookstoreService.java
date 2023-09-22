package com.quangminh.dtooffsetpagination.service;

import com.quangminh.dtooffsetpagination.dto.AuthorDto;
import com.quangminh.dtooffsetpagination.repository.AuthorRepository;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookstoreService {

    private final AuthorRepository authorRepository;

    public BookstoreService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }
    public Page<AuthorDto> fetchNextPageNative(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, "age"));

        List<AuthorDto> authors = authorRepository.fetchAllNative(pageable);
        Page<AuthorDto> pageOfAuthors = new PageImpl(authors, pageable,
                authors.isEmpty() ? 0 : authors.get(0).getTotal());

        return pageOfAuthors;
    }

    public Page<AuthorDto> fetchNextPageJpql(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, "age"));

        List<AuthorDto> authors = authorRepository.fetchAllJpql(pageable);
        Page<AuthorDto> pageOfAuthors = new PageImpl(authors, pageable,
                authors.isEmpty() ? 0 : authors.get(0).getTotal());

        return pageOfAuthors;
    }

    public List<AuthorDto> fetchNextPageNativeList(int page, int size) {

        return authorRepository.fetchAllNativeList(page, size);
    }

    public List<AuthorDto> fetchNextPageJpqlList(int page, int size) {

        Pageable pageable = PageRequest.of(page, size,Sort.by(Sort.Direction.ASC, "age"));

        return authorRepository.fetchAllJpqlList(pageable);
    }
}
