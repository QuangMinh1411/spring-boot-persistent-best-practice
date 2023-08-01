package com.quangminh.dtoconstructor.service;

import com.quangminh.dtoconstructor.dto.AuthorDto;
import com.quangminh.dtoconstructor.repository.AuthorRepository;
import jakarta.persistence.Tuple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookstoreService {

    @Autowired
    private AuthorRepository authorRepository;

    public List<AuthorDto> fetchByGenre(String genre) {

        return authorRepository.findByGenre(genre);
    }

    public List<AuthorDto> fetchAuthor(){
        return authorRepository.fetchAuthors();
    }

    public List<AuthorDto> fetchAuthorsByTuple(){
        List<AuthorDto> authors = new ArrayList<>();
        List<Tuple> authorsTupple = authorRepository.fetchAuthorsByTuple();
        authorsTupple.forEach(tuple -> {
            authors.add(new AuthorDto((Integer) tuple.get("age"), (String) tuple.get("name")));
        });
        return authors;
    }
}
