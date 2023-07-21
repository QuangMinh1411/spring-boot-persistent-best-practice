package com.heaven.subentities.service;

import com.heaven.subentities.entity.AuthorDeep;
import com.heaven.subentities.entity.AuthorShallow;
import com.heaven.subentities.repository.AuthorDeepRepository;
import com.heaven.subentities.repository.AuthorShallowRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookstoreService {
    private final AuthorShallowRepository authorShallowRepository;
    private final AuthorDeepRepository authorDeepRepository;

    @Transactional
    public AuthorDeep createAuthor(AuthorDeep author){
        return authorDeepRepository.save(author);
    }
    public List<AuthorShallow> fetchAuthorsShallow(){
        return authorShallowRepository.findAll();
    }

    public List<AuthorDeep> fetchAuthorDeep(){
        return authorDeepRepository.findAll();
    }
}
