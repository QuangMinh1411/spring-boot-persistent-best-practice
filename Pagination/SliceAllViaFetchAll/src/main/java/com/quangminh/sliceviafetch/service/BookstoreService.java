package com.quangminh.sliceviafetch.service;

import com.quangminh.sliceviafetch.dto.AuthorDto;
import com.quangminh.sliceviafetch.entity.Author;
import com.quangminh.sliceviafetch.repository.AuthorRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class BookstoreService {

    private final AuthorRepository authorRepository;

    public BookstoreService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }
    public Slice<Author> fetchNextSlice(int page, int size,String critical) {

        return authorRepository.fetchAll(PageRequest.of(page, size,
                Sort.by(Sort.Direction.ASC, critical)));
    }

    public Slice<AuthorDto> fetchNextSliceDto(int page, int size,String critical) {

        return authorRepository.fetchAllDto(PageRequest.of(page, size,
                Sort.by(Sort.Direction.ASC, critical)));
    }
}
