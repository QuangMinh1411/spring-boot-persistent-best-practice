package com.quangminh.dynamicupdate.service;

import com.quangminh.dynamicupdate.entity.Author;
import com.quangminh.dynamicupdate.repository.AuthorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookstoreService {

    private final AuthorRepository authorRepository;

    public BookstoreService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }
    //update attached entity
    @Transactional
    public void updateAuthor() {
        Author author = authorRepository.findById(1L).orElseThrow();

        author.setSellrank(222);
    }

    // updated detached entity
    @Transactional(readOnly = true)
    public Author fetchAuthor() {
        Author author = authorRepository.findById(1L).orElseThrow();

        return author;
    }

    @Transactional
    public void updateDetachedAuthor(Author author) {

        author.setSellrank(225);
        authorRepository.save(author);
    }
}
