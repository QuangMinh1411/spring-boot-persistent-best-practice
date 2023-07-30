package com.quangminh.projectionandcollections.service;

import com.quangminh.projectionandcollections.dto.AuthorDto;
import com.quangminh.projectionandcollections.dto.SimpleAuthorDto;
import com.quangminh.projectionandcollections.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
public class BookstoreService {

    @Autowired
    private AuthorRepository authorRepository;

    @Transactional(readOnly = true)
    public List<AuthorDto> fetchAuthorsWithBooksQueryBuilderMechanism() {
        return authorRepository.findBy();
    }


    @Transactional(readOnly = true)
    public List<AuthorDto> fetchAuthorsWithBooksViaQuery() {

        return authorRepository.findByViaQuery();
    }

    @Transactional(readOnly = true)
    public Set<AuthorDto> fetchAuthorsWithBooksViaJoinFetch() {

        return authorRepository.findByJoinFetch();
    }

    @Transactional(readOnly = true)
    public List<SimpleAuthorDto> fetchAuthorsWithBooksViaQuerySimpleDto() {


        return authorRepository.findByViaQuerySimpleDto();
    }

    @Transactional(readOnly = true)
    public List<Object[]> fetchAuthorsWithBooksViaArrayOfObjects() {


        return authorRepository.findByViaArrayOfObjects();
    }


}
