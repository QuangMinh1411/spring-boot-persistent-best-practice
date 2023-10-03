package com.quangminh.simulatenplus1.service;

import com.quangminh.simulatenplus1.entity.Author;
import com.quangminh.simulatenplus1.entity.Book;
import com.quangminh.simulatenplus1.repository.AuthorRepository;
import com.quangminh.simulatenplus1.repository.BookRepository;
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
    @Transactional(readOnly = true)
    public void fetchBooksAndAuthors() {

        List<Book> books = bookRepository.findAll();

        for (Book book : books) {
            Author author = book.getAuthor();
            System.out.println("Book: " + book.getTitle() + " Author: " + author.getName());
        }
    }

    @Transactional(readOnly = true)
    public void fetchAuthorsAndBooks() {

        List<Author> authors = authorRepository.findAll();

        for (Author author: authors) {
            List<Book> books = author.getBooks();
            System.out.println("Author: " + author.getName() + " Books: " + books);
        }
    }
}
