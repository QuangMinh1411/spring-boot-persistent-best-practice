package com.quangminh.extracolumn.service;

import com.quangminh.extracolumn.entity.Author;
import com.quangminh.extracolumn.repository.AuthorRepository;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookstoreService {
    private final AuthorRepository authorRepository;

    public BookstoreService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }
    public Page<Author> fetchNextPage(int page, int size) {

        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, "age"));

        List<Author> authors = authorRepository.fetchAll(pageable);
        Page<Author> pageOfAuthors = new PageImpl(authors, pageable,
                authors.isEmpty() ? 0 : authors.get(0).getTotal());

        return pageOfAuthors;
    }

    public List<Author> fetchNextPageList(int page,int size){
        return authorRepository.fetchAllList(page,size);
    }
    /* // this relies in Author.toString()
       // using this method requires the controller to return Map<List<Author>, Long> as well
    public Map<List<Author>, Long> fetchNextPage(int page, int size) {

        List<Author> authors = authorRepository.fetchAll(page, size);

        return Collections.singletonMap(authors, authors.isEmpty() ? 0 : authors.get(0).getTotal());
    }
     */
}
