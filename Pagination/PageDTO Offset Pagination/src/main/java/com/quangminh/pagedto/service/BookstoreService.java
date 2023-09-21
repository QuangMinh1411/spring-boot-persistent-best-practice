package com.quangminh.pagedto.service;

import com.quangminh.pagedto.dto.AuthorDto;
import com.quangminh.pagedto.repository.AuthorRepository;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookstoreService {

    private final AuthorRepository authorRepository;

    public BookstoreService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }
    public Page<AuthorDto> fetchNextPage(int page, int size,String critical) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, critical));

        List<AuthorDto> authors = authorRepository.fetchAll(pageable);
        Page<AuthorDto> pageOfAuthors = new PageImpl(authors, pageable,
                authors.isEmpty() ? 0 : authors.get(0).getTotal());

        return pageOfAuthors;
    }
    public List<AuthorDto> fetchNextPageWithTotal(int page, int size,String critical) {

        return authorRepository.fetchAllWithTotal(critical,page, size);
    }
}
