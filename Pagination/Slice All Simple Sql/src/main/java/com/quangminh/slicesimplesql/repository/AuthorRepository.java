package com.quangminh.slicesimplesql.repository;

import com.quangminh.slicesimplesql.entity.Author;
import com.quangminh.slicesimplesql.repository.impl.SlicePagingRepositoryImplementation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class AuthorRepository extends SlicePagingRepositoryImplementation {
    public AuthorRepository(){
        super(Author.class);
    }
}