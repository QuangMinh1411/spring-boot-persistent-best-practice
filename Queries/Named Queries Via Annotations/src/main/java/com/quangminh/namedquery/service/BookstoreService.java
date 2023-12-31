package com.quangminh.namedquery.service;

import com.quangminh.namedquery.entity.Author;
import com.quangminh.namedquery.repository.AuthorRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookstoreService {
    private final AuthorRepository authorRepository;

    public BookstoreService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> fetchAllAuthors() {
        return authorRepository.fetchAll();
    }

    public Author fetchAuthorByNameAndAge() {
        return authorRepository.fetchByNameAndAge("Joana Nimar", 34);
    }

    /* causes exception
    public List<Author> fetchAuthorsViaSort() {
        return authorRepository.fetchViaSort(Sort.by(Direction.DESC, "name"));
    }
    */

    /* exception
    public List<Author> fetchAuthorsViaSortWhere() {
        return authorRepository.fetchViaSortWhere(30, Sort.by(Direction.DESC, "name"));
    }
    */

    public Page<Author> fetchAuthorsPageSort() {
        return authorRepository.fetchPageSort(PageRequest.of(1, 3,
                Sort.by(Sort.Direction.DESC, "name")));
    }

    public Page<Author> fetchAuthorsPageSortWhere() {
        return authorRepository.fetchPageSortWhere(30, PageRequest.of(1, 3,
                Sort.by(Sort.Direction.DESC, "name")));
    }

    public Slice<Author> fetchAuthorsSliceSort() {
        return authorRepository.fetchSliceSort(PageRequest.of(1, 3,
                Sort.by(Sort.Direction.DESC, "name")));
    }

    public Slice<Author> fetchAuthorsSliceSortWhere() {
        return authorRepository.fetchSliceSortWhere(30, PageRequest.of(1, 3,
                Sort.by(Sort.Direction.DESC, "name")));
    }

    public List<Author> fetchAllAuthorsNative() {
        return authorRepository.fetchAllNative();
    }

    public Author fetchAuthorByNameAndAgeNative() {
        return authorRepository.fetchByNameAndAgeNative("Joana Nimar", 34);
    }

    /* causes exception
    public List<Author> fetchAuthorsViaSortNative() {
        return authorRepository.fetchViaSortNative(Sort.by(Direction.DESC, "name"));
    }
    */

    /* exception
    public List<Author> fetchAuthorsViaSortWhereNative() {
        return authorRepository.fetchViaSortWhereNative(30, Sort.by(Direction.DESC, "name"));
    }
    */

    public Page<Author> fetchAuthorsPageSortNative() {
        return authorRepository.fetchPageSortNative(PageRequest.of(1, 3,
                Sort.by(Sort.Direction.DESC, "name")));
    }

    public Page<Author> fetchAuthorsPageSortWhereNative() {
        return authorRepository.fetchPageSortWhereNative(30, PageRequest.of(1, 3,
                Sort.by(Sort.Direction.DESC, "name")));
    }

    public Slice<Author> fetchAuthorsSliceSortNative() {
        return authorRepository.fetchSliceSortNative(PageRequest.of(1, 3,
                Sort.by(Sort.Direction.DESC, "name")));
    }

    public Slice<Author> fetchAuthorsSliceSortWhereNative() {
        return authorRepository.fetchSliceSortWhereNative(30, PageRequest.of(1, 3,
                Sort.by(Sort.Direction.DESC, "name")));
    }
}
