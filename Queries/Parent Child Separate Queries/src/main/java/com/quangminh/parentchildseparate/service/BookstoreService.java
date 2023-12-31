package com.quangminh.parentchildseparate.service;

import com.quangminh.parentchildseparate.entity.Author;
import com.quangminh.parentchildseparate.entity.Book;
import com.quangminh.parentchildseparate.repository.AuthorRepository;
import com.quangminh.parentchildseparate.repository.BookRepository;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookstoreService {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BookstoreService(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    // first query/request
    public Author fetchAuthor(long id) {

        return authorRepository.findById(id).orElseThrow();
    }

    // second query/request
    @Transactional(readOnly = true)
    public List<Book> fetchBooksOfAuthorBad(Author a) {

        Author author = fetchAuthor(a.getId());
        List<Book> books = author.getBooks();

        Hibernate.initialize(books);
        // books.size();

        return books;
    }

    // second query/request
    public List<Book> fetchBooksOfAuthorGood(Author a) {

        // Explicit JPQL
        // return bookRepository.fetchByAuthor(a);

        // Query Builder
        return bookRepository.findByAuthor(a);
    }

    // first query/request
    public Book fetchBook(long id) {

        return bookRepository.findById(id).orElseThrow();
    }

    // second query/request
    @Transactional(readOnly = true)
    public Author fetchAuthorOfBookBad(Book b) {

        Book book = fetchBook(b.getId());
        Author author = book.getAuthor();

        Hibernate.initialize(author);

        return author;
    }

    // second query/request
    public Author fetchAuthorOfBookGood(Book b) {

        // Explicit JPQL
        // return authorRepository.fetchByBooks(b);

        // Query Builder
        return authorRepository.findByBooks(b);
    }
}
