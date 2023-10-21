package com.quangminh.specqueryfetchjoin.service;

import com.quangminh.specqueryfetchjoin.entity.Author;
import com.quangminh.specqueryfetchjoin.repository.AuthorRepository;
import com.quangminh.specqueryfetchjoin.specs.JoinFetchInIdsSpecification;
import com.quangminh.specqueryfetchjoin.specs.JoinFetchSpecification;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookstoreService {

    private final AuthorRepository authorRepository;

    public BookstoreService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Page<Author> fetchViaJoinFetchSpecification(int page, int size,String genre) {

        Pageable pageable = PageRequest.of(page, size,
                Sort.by(Sort.Direction.ASC, "name"));

        Page<Author> pageOfAuthors = authorRepository
                .findAll(new JoinFetchSpecification(genre), pageable);

        return pageOfAuthors;
    }

    @Transactional(readOnly = true)
    public Page<Author> fetchViaJoinFetchInIdsSpecification(int page, int size,String genre) {

        Pageable pageable = PageRequest.of(page, size,
                Sort.by(Sort.Direction.ASC, "name"));

        Page<Long> pageOfIds = authorRepository.fetchPageOfIdsByGenre(genre, pageable);
        List<Author> listOfAuthors = authorRepository.findAll(
                new JoinFetchInIdsSpecification(pageOfIds.getContent()));
        Page<Author> pageOfAuthors = new PageImpl(
                listOfAuthors, pageable, pageOfIds.getTotalElements());

        return pageOfAuthors;
    }
}
