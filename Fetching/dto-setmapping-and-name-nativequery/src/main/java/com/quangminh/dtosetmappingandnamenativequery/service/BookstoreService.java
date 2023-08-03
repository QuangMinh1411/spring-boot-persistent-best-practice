package com.quangminh.dtosetmappingandnamenativequery.service;

import com.quangminh.dtosetmappingandnamenativequery.dao.AuthorDaoImpl;
import com.quangminh.dtosetmappingandnamenativequery.dto.AuthorDto;
import com.quangminh.dtosetmappingandnamenativequery.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookstoreService {

    private final AuthorRepository authorRepository;
    private final AuthorDaoImpl dao;

    public BookstoreService(AuthorRepository authorRepository, AuthorDaoImpl dao) {
        this.authorRepository = authorRepository;
        this.dao = dao;
    }
    public List<AuthorDto> fetchAuthorsNameAndAge(){
        return authorRepository.fetchNameAndAge();
    }
    public List<AuthorDto> fetchNameAndAgeXml(){
        return authorRepository.fetchNameAndAgeXml();
    }

    public List<String> fetchAuthorName(){
        return authorRepository.fetchName();
    }

    public List<AuthorDto> fetchAuthorByEntity(){
        return dao.fetchNameAndAge();
    }
}
