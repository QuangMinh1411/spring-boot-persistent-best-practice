package com.quangminh.limitresult.service;

import com.quangminh.limitresult.dto.AuthorDto;
import com.quangminh.limitresult.entity.Author;
import com.quangminh.limitresult.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookstoreService {

    private final AuthorRepository authorRepository;

    public BookstoreService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> fetchFirst5() {
        return authorRepository.findFirst5By();
    }

    public List<Author> fetchFirst5ByAge(int age) {
        return authorRepository.findFirst5ByAge(age);
    }

    public List<Author> fetchFirst5ByAgeGreaterThanEqual(int age) {
        return authorRepository.findFirst5ByAgeGreaterThanEqual(age);
    }

    public List<Author> fetchFirst5ByAgeLessThan(int age) {
        return authorRepository.findFirst5ByAgeLessThan(age);
    }

    public List<Author> fetchFirst5ByAgeOrderByNameDesc(int age) {
        return authorRepository.findFirst5ByAgeOrderByNameDesc(age);
    }

    public List<Author> fetchFirst5ByGenreOrderByAgeAsc(String genre) {
        return authorRepository.findFirst5ByGenreOrderByAgeAsc(genre);
    }

    public List<Author> fetchFirst5ByAgeGreaterThanEqualOrderByNameAsc(int age) {
        return authorRepository.findFirst5ByAgeGreaterThanEqualOrderByNameAsc(age);
    }

    public List<Author> fetchFirst5ByGenreAndAgeLessThanOrderByNameDesc(String genre, int age) {
        return authorRepository.findFirst5ByGenreAndAgeLessThanOrderByNameDesc(genre, age);
    }

    public List<AuthorDto> fetchFirst5ByOrderByAgeAsc() {
        return authorRepository.findFirst5ByOrderByAgeAsc();
    }
}
