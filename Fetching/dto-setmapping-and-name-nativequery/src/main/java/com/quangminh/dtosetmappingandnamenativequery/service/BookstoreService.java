package com.quangminh.dtosetmappingandnamenativequery.service;

import com.quangminh.dtosetmappingandnamenativequery.dto.AuthorDto;
import com.quangminh.dtosetmappingandnamenativequery.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookstoreService {

    private final AuthorRepository authorRepository;

    public BookstoreService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
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
}
