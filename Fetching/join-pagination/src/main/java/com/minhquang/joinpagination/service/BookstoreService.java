package com.minhquang.joinpagination.service;

import com.minhquang.joinpagination.dto.AuthorBookDto;
import com.minhquang.joinpagination.repository.AuthorRepository;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookstoreService {

    private final AuthorRepository authorRepository;

    public BookstoreService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Page<AuthorBookDto> fetchPageOfAuthorsWithBooksDtoByGenre(String genre,int page, int size) {

        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, "name"));
        Page<AuthorBookDto> pageOfAuthors = authorRepository.fetchPageOfDto(genre, pageable);

        return pageOfAuthors;
    }

    public Slice<AuthorBookDto> fetchSliceOfAuthorsWithBooksDtoByGenre(String genre,int page, int size) {

        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, "name"));
        Slice<AuthorBookDto> sliceOfAuthors = authorRepository.fetchSliceOfDto(genre, pageable);

        return sliceOfAuthors;
    }

    public List<AuthorBookDto> fetchListOfAuthorsWithBooksDtoByGenre(String genre,int page, int size) {

        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, "name"));
        List<AuthorBookDto> listOfAuthors = authorRepository.fetchListOfDto(genre, pageable);

        return listOfAuthors;
    }

    public Page<AuthorBookDto> fetchPageOfAuthorsWithBooksDtoByGenreNative(String genre,int page, int size) {

        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, "name"));

        List<AuthorBookDto> listOfAuthors
                = authorRepository.fetchListOfDtoNative(genre, pageable);
        Page<AuthorBookDto> pageOfAuthors
                = new PageImpl(listOfAuthors, pageable,
                listOfAuthors.isEmpty() ? 0 : listOfAuthors.get(0).getTotal());

        return pageOfAuthors;
    }

    public List<AuthorBookDto> fetchListOfAuthorsWithBooksDtoNativeDenseRank(String genre,int start, int end) {

        List<AuthorBookDto> listOfAuthors
                = authorRepository.fetchListOfDtoNativeDenseRank(genre, start, end);

        return listOfAuthors;
    }
}
