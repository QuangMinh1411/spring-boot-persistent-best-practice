package com.quangminh.dtoviajoin.service;

import com.quangminh.dtoviajoin.entity.Author;
import com.quangminh.dtoviajoin.projection.AuthorRepository;
import com.quangminh.dtoviajoin.repository.AuthorNameBookTitle;
import com.quangminh.dtoviajoin.repository.BookRepository;
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

    public List<AuthorNameBookTitle> findAuthorsAndBooksJpql(){
        return authorRepository.findAuthorsAndBooksJpql();
    }

    public List<AuthorNameBookTitle> findAuthorsAndBooksSql(){
        return authorRepository.findAuthorsAndBooksJpql();
    }

    public List<AuthorNameBookTitle> findAuthorsAndBooksByGenreAndPriceJpql(String genre, int price){
        return  authorRepository.findAuthorsAndBooksByGenreAndPriceJpql(genre, price);
    }

    public List<AuthorNameBookTitle> findBooksAndAuthorsByGenreAndPriceSql(String genre, int price){
        return bookRepository.findBooksAndAuthorsByGenreAndPriceSql(genre,price);
    }

    // Fetch books and authors including books that have no registered author (JPQL)
    public List<AuthorNameBookTitle> fetchBooksAndAuthorsJpql() {
        return bookRepository.findBooksAndAuthorsJpql();
    }

    // Fetch books and authors including books that have no registered author (SQL)
    public List<AuthorNameBookTitle> fetchBooksAndAuthorsSql() {
        return bookRepository.findBooksAndAuthorsSql();
    }

    // Fetch authors and books including authors that have no registered book (JPQL)
    public List<AuthorNameBookTitle> fetchAuthorsAndBooksJpql() {
        return authorRepository.findAuthorsAndBooksJpql();
    }

    // Fetch authors and books including authors that have no registered book (SQL)
    public List<AuthorNameBookTitle> fetchAuthorsAndBooksSqlLeftJoinExcluding() {
        return authorRepository.findAuthorsAndBooksSql();
    }

    // Fetch books and authors excluding books that have registered authors (JPQL)
    public List<AuthorNameBookTitle> fetchBooksAndAuthorsJpqlLeftJoinExcluding() {
        return bookRepository.findBooksAndAuthorsJpqlLeftJoinExcluding();
    }

    // Fetch books and authors excluding books that have registered authors (SQL)
    public List<AuthorNameBookTitle> fetchBooksAndAuthorsSqlLeftJoinExcluding() {
        return bookRepository.findBooksAndAuthorsSqlLeftJoinExcluding();
    }

    // Fetch authors and books excluding authors that have registered books (JPQL)
    public List<AuthorNameBookTitle> fetchAuthorsAndBooksJpql() {
        return authorRepository.findAuthorsAndBooksJpql();
    }

    // Fetch authors and books excluding authors that have registered books (SQL)
    public List<AuthorNameBookTitle> fetchAuthorsAndBooksSql() {
        return authorRepository.findAuthorsAndBooksSql();
    }
}
