package com.quangminh.joinfetchpagable.service;

import com.quangminh.joinfetchpagable.entity.Author;
import com.quangminh.joinfetchpagable.entity.Book;
import com.quangminh.joinfetchpagable.repository.AuthorRepository;
import com.quangminh.joinfetchpagable.repository.BookRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class BookstoreService {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;


    public BookstoreService(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    public Page<Author> fetchWithBooksByGenreCQ(String genre,int page,int size) {

        return authorRepository.fetchWithBooksByGenreCQ(genre,
                PageRequest.of(page, size, Sort.Direction.ASC, "name"));
    }

    public Page<Author> fetchWithBooksByGenreEG(String genre,int page,int size) {

        return authorRepository.fetchWithBooksByGenreEG(genre,
                PageRequest.of(page,size,Sort.Direction.ASC, "name"));
    }

    public Page<Book> fetchWithAuthorsByIsbnCQ(String isbn,int page,int size) {

        return bookRepository.fetchWithAuthorsByIsbnCQ(isbn,
                PageRequest.of(page, size, Sort.Direction.ASC, "title"));
    }

    public Page<Book> fetchWithAuthorsByIsbnEG(String isbn,int page,int size) {

        return bookRepository.fetchWithAuthorsByIsbnEG(isbn,
                PageRequest.of(page, size, Sort.Direction.ASC, "title"));
    }
}
