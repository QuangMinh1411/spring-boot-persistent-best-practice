package com.minhquang.streammysql.service;

import com.minhquang.streammysql.dto.BookDto;
import com.minhquang.streammysql.entity.Author;
import com.minhquang.streammysql.entity.Book;
import com.minhquang.streammysql.repository.AuthorRepository;
import com.minhquang.streammysql.repository.BookRepository;
import com.minhquang.streammysql.wrapper.Books;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

@Service
public class BookstoreService {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BookstoreService(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Transactional(readOnly = true)
    public Stream<Author> streamDatabase(){
        return authorRepository.streamAll();
    }

    public Streamable<Author> fetchAuthorsAsStreamable(String genre) {

        return authorRepository.findByGenre(genre);

    }

    public Streamable<Author> fetchAuthorsDtoAsStreamable() {

       return authorRepository.findBy();

    }

    public Streamable<Author> fetchAuthorsByGenreAndAgeGreaterThan(String genre,int age) {

        return authorRepository.findByGenreAndAgeGreaterThan(genre, age);

    }

    public Streamable<Author> fetchAuthorsByGenreOrAgeGreaterThan(String genre,int age) {

        return authorRepository.findByGenreOrAgeGreaterThan(genre, age);

    }

    // Caution: Don't do this! Fetch all columns just to drop a part of them
    public Stream<String> fetchAuthorsNames1(String genre) {

        return (Stream<String>) authorRepository.findByGenre(genre).map(Author::getName);

    }

    // Do this
    public Streamable<Author> fetchAuthorsNames2(String genre) {

        return authorRepository.queryByGenre(genre);

    }

    // Caution: Don't do this! Fetch more rows than needed just to throw away a part of it
    public Streamable<Author> fetchAuthorsOlderThanAge1(String genre,int age) {

        return  authorRepository.findByGenre(genre)
                .filter(a -> a.getAge() >age);


    }

    // Do this! Fetch more rows than needed just to throw away a part of it
    public Streamable<Author> fetchAuthorsOlderThanAge2(String genre,int age) {

        return authorRepository.findByGenreAndAgeGreaterThan(genre, age);

    }

    // Caution: It triggers two SELECT statements and the
    // final result is the concatenation of the these two results sets!
    @Transactional(readOnly = true)
    public Streamable<Author> fetchAuthorsByGenreConcatAge(String genre,int age) {

        return authorRepository.findByGenre(genre)
                .and(authorRepository.findByAgeGreaterThan(age));


    }

    @Transactional
    public List<BookDto> updateBookPrice(int price) {

        Books books = bookRepository.findBy();

        int sumPricesBefore = books.sumPrices();
        System.out.println("Total prices before update: " + sumPricesBefore);

        Map<Boolean, List<Book>> booksMap = books.partitionByPrice(price);

        booksMap.get(Boolean.TRUE).forEach(
                a -> a.setPrice(a.getPrice() + 3));

        booksMap.get(Boolean.FALSE).forEach(
                a -> a.setPrice(a.getPrice() + 5));

        int sumPricesAfter = books.sumPrices();
        System.out.println("Total prices after update: " + sumPricesAfter);

        return books.toBookDto();
    }
}
