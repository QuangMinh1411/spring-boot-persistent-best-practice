package com.quangminh.softdelete.service;

import com.quangminh.softdelete.entity.Author;
import com.quangminh.softdelete.entity.Book;
import com.quangminh.softdelete.repository.AuthorRepository;
import com.quangminh.softdelete.repository.BookRepository;
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
    @Transactional
    public void softDeleteBook(Long authorId,int index) {
        Author author = authorRepository.findById(authorId).get();
        Book book = author.getBooks().get(index);

        author.removeBook(book);
    }

    @Transactional
    public void softDeleteAuthor(Long id) {
        Author author = authorRepository.findById(id).get();

        authorRepository.delete(author);
    }

    @Transactional
    public void restoreBook(Long id) {
        bookRepository.restoreById(id);
    }

    @Transactional
    public void restoreAuthor(Long authorId) {
        bookRepository.restoreByAuthorId(authorId);
        authorRepository.restoreById(authorId);

    }

    public List<Author> displayAllExceptDeletedAuthors() {
        List<Author> authors = authorRepository.findAll();

        System.out.println("\nAll authors except deleted:");
        authors.forEach(a -> System.out.println("Author name: " + a.getName()));
        System.out.println();
        return authors;
    }

    public List<Author> displayAllIncludeDeletedAuthors() {
        List<Author> authors = authorRepository.findAllIncludingDeleted();

        System.out.println("\nAll authors including deleted:");
        authors.forEach(a -> System.out.println("Author name: " + a.getName()));
        System.out.println();
        return authors;
    }

    public List<Author> displayAllOnlyDeletedAuthors() {
        List<Author> authors = authorRepository.findAllOnlyDeleted();

        System.out.println("\nAll deleted authors:");
        authors.forEach(a -> System.out.println("Author name: " + a.getName()));
        System.out.println();
        return authors;
    }

    public List<Book> displayAllExceptDeletedBooks() {
        List<Book> books = bookRepository.findAll();

        System.out.println("\nAll books except deleted:");
        books.forEach(b -> System.out.println("Book title: " + b.getTitle()));
        System.out.println();
        return books;
    }

    public List<Book> displayAllIncludeDeletedBooks() {
        List<Book> books = bookRepository.findAllIncludingDeleted();

        System.out.println("\nAll books including deleted:");
        books.forEach(b -> System.out.println("Book title: " + b.getTitle()));
        System.out.println();
        return books;
    }

    public List<Book> displayAllOnlyDeletedBooks() {
        List<Book> books = bookRepository.findAllOnlyDeleted();

        System.out.println("\nAll deleted books:");
        books.forEach(b -> System.out.println("Book title: " + b.getTitle()));
        System.out.println();
        return books;
    }
}
