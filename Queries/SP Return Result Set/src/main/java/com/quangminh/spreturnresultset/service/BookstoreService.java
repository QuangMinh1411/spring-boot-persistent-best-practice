package com.quangminh.spreturnresultset.service;

import com.quangminh.spreturnresultset.dao.Dao;
import com.quangminh.spreturnresultset.dto.AuthorDto;
import com.quangminh.spreturnresultset.entity.Author;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookstoreService {
    private final Dao dao;

    public BookstoreService(Dao dao) {
        this.dao = dao;
    }
    public List<Author> fetchAnthologyAuthorsViaNamedStoredProcedure(String genre) {
        List<Author> authors = dao.fetchByGenre1(genre);
        authors.forEach(a -> System.out.println(a));
        return authors;
    }

    public List<Author> fetchAnthologyAuthorsViaStoredProcedure(String genre) {
        List<Author> authors = dao.fetchByGenre2(genre);
        authors.forEach(a -> System.out.println(a));
        return authors;
    }

    public List<AuthorDto> fetchAnthologyDtoAuthorsViaStoredProcedure(String genre) {
        List<AuthorDto> authors = dao.fetchByGenre3(genre);
        authors.forEach(a -> System.out.println(a));
        return authors;
    }

    public List<AuthorDto> fetchAnthologyManualMappingDtoAuthorsViaStoredProcedure(String genre) {
        List<AuthorDto> authors = dao.fetchByGenre4(genre);
        authors.forEach(a -> System.out.println(a));
        return authors;
    }
}
