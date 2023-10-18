package com.quangminh.topnrowsgroup.service;

import com.quangminh.topnrowsgroup.entity.Author;
import com.quangminh.topnrowsgroup.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookstoreService {

    private final AuthorRepository authorRepository;

    public BookstoreService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> fetchAuthorTopBySales(int top){
        return authorRepository.fetchTopBySales(top);
    }
}
