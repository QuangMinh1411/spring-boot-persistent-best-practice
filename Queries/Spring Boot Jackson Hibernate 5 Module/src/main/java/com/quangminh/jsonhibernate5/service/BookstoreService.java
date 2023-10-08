package com.quangminh.jsonhibernate5.service;

import com.quangminh.jsonhibernate5.entity.Author;
import com.quangminh.jsonhibernate5.entity.Book;
import com.quangminh.jsonhibernate5.repository.AuthorRepository;
import com.quangminh.jsonhibernate5.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookstoreService {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BookstoreService(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }
    public Author fetchAuthorWithBooks(String name) {

        return authorRepository.findByNameWithBooks(name);
    }

    public Optional<Author> fetchAuthorWithoutBooks(String name) {

        return authorRepository.findByName(name);
    }

    public List<Book> fetchBooks(String text){
        return bookRepository.findByTitleContainingIgnoreCase(text);
    }
    // @Transactional(readOnly=true) -> this makes the things even worse
    public void displayAuthors(List<Book> books) {

        books.forEach(b -> System.out.println(b.getAuthor()));
    }
}
