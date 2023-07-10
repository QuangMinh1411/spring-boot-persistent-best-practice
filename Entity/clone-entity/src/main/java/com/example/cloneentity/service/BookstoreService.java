package com.example.cloneentity.service;

import com.example.cloneentity.entity.Author;
import com.example.cloneentity.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BookstoreService {
    private final AuthorRepository authorRepository;

    @Transactional
    public Author cloneAuthor(String name,int age,String aname,boolean isClone){
        Author author = authorRepository.fetchByName(name);
        Author authorClone = new Author(author,isClone);
        authorClone.setAge(age);
        authorClone.setName(aname);
        return authorRepository.save(authorClone);
    }
}
