package com.quangminh.slicecritialbuilder.repository;

import com.quangminh.slicecritialbuilder.entity.Author;
import com.quangminh.slicecritialbuilder.repository.impl.SlicePagingRepositoryImplementation;
import org.springframework.stereotype.Repository;

@Repository
public class AuthorRepository extends SlicePagingRepositoryImplementation<Author> {
    public AuthorRepository() {
        super(Author.class);
    }
}
