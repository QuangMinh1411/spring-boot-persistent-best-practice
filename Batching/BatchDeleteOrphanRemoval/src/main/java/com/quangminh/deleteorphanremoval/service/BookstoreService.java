package com.quangminh.deleteorphanremoval.service;

import com.quangminh.deleteorphanremoval.entity.Author;
import com.quangminh.deleteorphanremoval.repository.AuthorRepository;
import com.quangminh.deleteorphanremoval.repository.BookRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookstoreService {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BookstoreService(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Transactional
    public void deleteAuthorsAndBooksViaDeleteAllInBatch() {
        authorRepository.deleteAllInBatch();
        bookRepository.deleteAllInBatch();
    }

    // explicitly delete all records from each table
    @Transactional
    public void deleteAuthorsAndBooksViaDeleteInBatch(int age) {
        List<Author> authors = authorRepository.fetchAuthorsAndBooks(age);

        authorRepository.deleteInBatch(authors);
        authors.forEach(a -> bookRepository.deleteInBatch(a.getBooks()));
    }

    // good if you need to delete in a classical batch approach
    // deletes are cascaded by CascadeType.REMOVE and batched as well
    // the DELETE statements are not sorted at all and this causes more batches than needed for this job
    @Transactional
    public void deleteAuthorsAndBooksViaDeleteAll(int age) {
        List<Author> authors = authorRepository.fetchAuthorsAndBooks(age);

        authorRepository.deleteAll(authors); // for deleting all Authors use deleteAll()
    }

    // good if you need to delete in a classical batch approach
    // (uses orphanRemoval = true, and optimize the number of batches)
    @Transactional
    public void deleteAuthorsAndBooksViaDelete(int age) {

        List<Author> authors = authorRepository.fetchAuthorsAndBooks(age);

        authors.forEach(Author::removeBooks);
        authorRepository.flush();

        authors.forEach(authorRepository::delete); // or, authorRepository.deleteAll(authors);
    }
}
