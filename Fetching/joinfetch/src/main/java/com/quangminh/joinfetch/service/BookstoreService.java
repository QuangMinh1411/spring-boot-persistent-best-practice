package com.quangminh.joinfetch.service;

import com.quangminh.joinfetch.entity.Author;
import com.quangminh.joinfetch.entity.Book;
import com.quangminh.joinfetch.repository.AuthorRepository;
import com.quangminh.joinfetch.repository.BookRepository;
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

    public Author fetchAuthorWithBooksByName(String name) {

        return authorRepository.fetchAuthorWithBooksByName(name);
    }

    public Book fetchBookWithAuthorByIsbn(String isbn) {

        return bookRepository.fetchBookWithAuthorByIsbn(isbn);
    }

    // INNER JOIN
    @Transactional(readOnly = true)
    public List<Author> fetchAuthorsBooksByPriceInnerJoin(int price) {
        return authorRepository.fetchAuthorsBooksByPriceInnerJoin(price);

         // causes extra SELECTs and the result is not ok
    }

    // INNER JOIN BAD
    @Transactional(readOnly = true)
    public List<Book> fetchBooksAuthorsInnerJoinBad() {
        return bookRepository.fetchBooksAuthorsInnerJoinBad();

         // causes extra SELECTs but the result is ok
    }

    // INNER JOIN GOOD
    @Transactional(readOnly = true)
    public List<Book> fetchBooksAuthorsInnerJoinGood() {
        List<Book> books = bookRepository.fetchBooksAuthorsInnerJoinGood();

        books.forEach((e) -> System.out.println("Book title: " + e.getTitle() + ", Isbn: " + e.getIsbn()
                + ", author: " + e.getAuthor().getName())); // causes extra SELECTs but the result is ok
        return books;
    }

    // JOIN FETCH
    public List<Author> fetchAuthorsBooksByPriceJoinFetch() {
        List<Author> authors = authorRepository.fetchAuthorsBooksByPriceJoinFetch(40);

        authors.forEach((e) -> System.out.println("Author name: " + e.getName()
                + ", books: " + e.getBooks())); // does not cause extra SELECTs and the result is ok
        return authors;

    }

    // JOIN FETCH
    public List<Book> fetchBooksAuthorsJoinFetch() {
        List<Book> books = bookRepository.fetchBooksAuthorsJoinFetch();

        books.forEach((e) -> System.out.println("Book title: " + e.getTitle() + ", Isbn:" + e.getIsbn()
                + ", author: " + e.getAuthor())); // does not cause extra SELECTs and the result is ok

        return books;
    }
}
