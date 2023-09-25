package com.quangminh.slicecritialbuilder.service;

import com.quangminh.slicecritialbuilder.entity.Author;
import com.quangminh.slicecritialbuilder.repository.AuthorRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import static com.quangminh.slicecritialbuilder.service.AuthorSpecs.isAgeGt45;

@Service
public class BookstoreService {
    private final AuthorRepository authorRepository;

    public BookstoreService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

//    public Slice<Author> fetchNextSlice(int page, int size) {
//
//        return authorRepository.findAll(PageRequest.of(page, size));
//    }

    //Criteria Builder Sort
//    public Slice<Author> fetchNextSlice(int page, int size) {
//
//        return authorRepository.findAll(PageRequest.of(page, size, Sort.by(Sort.Direction.DESC,"age")));
//    }

//    public Slice<Author> fetchNextSlice(int page, int size) {
//
//        return authorRepository.findAll(isAgeGt45(),
//                PageRequest.of(page, size, Sort.by(Sort.Direction.ASC,"age")));
//    }

    public Slice<Author> fetchNextSlice(int page, int size) {

        return authorRepository.findAll(PageRequest.of(page, size));
    }

}
