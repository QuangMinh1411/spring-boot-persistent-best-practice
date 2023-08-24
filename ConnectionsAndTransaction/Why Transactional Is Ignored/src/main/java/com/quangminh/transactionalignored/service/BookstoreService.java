package com.quangminh.transactionalignored.service;

import com.quangminh.transactionalignored.entity.Author;
import com.quangminh.transactionalignored.repository.AuthorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.logging.Logger;

@Service
public class BookstoreService {
    private static final Logger log = Logger.getLogger(BookstoreService.class.getName());

    private final AuthorRepository authorRepository;
    private final HelperService helperService;

    public BookstoreService(AuthorRepository authorRepository, HelperService helperService) {
        this.authorRepository = authorRepository;
        this.helperService = helperService;
    }

    public void mainAuthor() {
        Author author = new Author();
        // persistAuthor(author);
        helperService.persistAuthor(author);
        notifyAuthor(author);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    private long persistAuthor(Author author) {
        authorRepository.save(author);
        return authorRepository.count();
    }

    private void notifyAuthor(Author author) {
        log.info(() -> "Saving author: " + author);
    }
}
