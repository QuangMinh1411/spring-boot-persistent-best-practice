package com.quangminh.savemerge.service;

import com.quangminh.savemerge.entity.Author;
import com.quangminh.savemerge.repository.AuthorRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookstoreService {
    @PersistenceContext
    private final EntityManager entityManager;

    private final AuthorRepository authorRepository;

    public BookstoreService(AuthorRepository authorRepository,
                            EntityManager entityManager) {

        this.authorRepository = authorRepository;
        this.entityManager = entityManager;
    }

    public Author fetchAuthorById(long id) {

        return authorRepository.findById(id).orElseThrow();
    }

    public void updateAuthorViaMerge(Author author) {

        authorRepository.save(author);
    }

    @Transactional
    public void updateAuthorViaUpdate(Author author) {

        Session session = entityManager.unwrap(Session.class);
        session.update(author);
    }
}
