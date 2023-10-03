package com.quangminh.fetchjoinqueries.service;

import com.quangminh.fetchjoinqueries.entity.Book;
import com.quangminh.fetchjoinqueries.repository.BookRepositoryEntityGraph;
import com.quangminh.fetchjoinqueries.repository.BookRepositoryFetchModeJoin;
import com.quangminh.fetchjoinqueries.repository.BookRepositoryJoinFetch;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.quangminh.fetchjoinqueries.specs.BookSpecs.isPriceGt35;

@Service
public class BookstoreService {
    private final BookRepositoryFetchModeJoin bookRepositoryFetchModeJoin;
    private final BookRepositoryEntityGraph bookRepositoryEntityGraph;
    private final BookRepositoryJoinFetch bookRepositoryJoinFetch;

    public BookstoreService(BookRepositoryFetchModeJoin bookRepositoryFetchModeJoin,
                            BookRepositoryEntityGraph bookRepositoryEntityGraph,
                            BookRepositoryJoinFetch bookRepositoryJoinFetch) {

        this.bookRepositoryFetchModeJoin = bookRepositoryFetchModeJoin;
        this.bookRepositoryEntityGraph = bookRepositoryEntityGraph;
        this.bookRepositoryJoinFetch = bookRepositoryJoinFetch;
    }

    public Book displayBookById(long id) {

        Book book = bookRepositoryFetchModeJoin.findById(id).orElseThrow(); // LEFT JOIN
//        displayBook(book);
        return book;
    }

    public Book displayBookByIdViaJoinFetch(long id) {

        Book book = bookRepositoryJoinFetch.findById(id).orElseThrow(); // LEFT JOIN
//        displayBook(book);
        return book;
    }

    public Book displayBookByIdViaEntityGraph(long id) {

        Book book = bookRepositoryEntityGraph.findById(id).orElseThrow(); // LEFT JOIN
//        displayBook(book);
        return book;
    }

    public List<Book> displayBooksCausingNPlus1() {

        List<Book> books = bookRepositoryFetchModeJoin.findAll(); // N+1
//        displayBooks(books);
        return books;
    }

    public List<Book> displayBooksByAgeGt45CausingNPlus1() {

        List<Book> books = bookRepositoryFetchModeJoin.findAll(isPriceGt35()); // N+1
//        displayBooks(books);
        return books;
    }

    public List<Book> displayBooksViaEntityGraph() {

        List<Book> books = bookRepositoryEntityGraph.findAll(); // LEFT JOIN
//        displayBooks(books);
        return books;
    }

    public List<Book> displayBooksByAgeGt45ViaEntityGraph() {

        List<Book> books = bookRepositoryEntityGraph.findAll(isPriceGt35()); // LEFT JOIN
//        displayBooks(books);
        return books;
    }

    public List<Book> displayBooksViaJoinFetch() {

        List<Book> books = bookRepositoryJoinFetch.findAll(); // LEFT JOIN
//        displayBooks(books);
        return books;
    }

    private void displayBook(Book book) {

        System.out.println(book);
        System.out.println(book.getAuthor());
        System.out.println(book.getAuthor().getPublisher() + "\n");
    }

    private void displayBooks(List<Book> books) {

        for (Book book : books) {
            System.out.println(book);
            System.out.println(book.getAuthor());
            System.out.println(book.getAuthor().getPublisher() + "\n");
        }
    }
}
