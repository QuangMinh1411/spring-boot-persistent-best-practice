package com.quangminh.resultsetmappingnamednavtivequery.service;

import com.quangminh.resultsetmappingnamednavtivequery.dto.AuthorDto;
import com.quangminh.resultsetmappingnamednavtivequery.entity.Author;
import com.quangminh.resultsetmappingnamednavtivequery.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookstoreService {

    @Autowired
    private AuthorRepository authorRepository;

    public List<Author> fetchAuthors(){
        return authorRepository.fetchAll();
    }

    public List<AuthorDto> fetchAuthorWithBook(){
        return authorRepository.fetchAuthorWithBook();
    }
}
