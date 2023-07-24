package com.example.dtoviaprojectioninterfaceinrepo.service;

import com.example.dtoviaprojectioninterfaceinrepo.repository.AuthorRepository;
import com.example.dtoviaprojectioninterfaceinrepo.repository.AuthorRepository.AuthorNameAge;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookstoreService {
    private final AuthorRepository authorRepository;

    public BookstoreService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<AuthorNameAge> fetchFirst2ByBirthplace(String genre){
        return authorRepository.findFirst2ByGenre(genre);
    }
}
