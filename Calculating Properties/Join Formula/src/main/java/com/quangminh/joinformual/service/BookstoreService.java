package com.quangminh.joinformual.service;

import com.quangminh.joinformual.entity.Author;
import com.quangminh.joinformual.entity.Book;
import com.quangminh.joinformual.repository.AuthorRepository;
import com.quangminh.joinformual.repository.BookRepository;
import org.springframework.data.auditing.AuditingHandler;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookstoreService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;


    public BookstoreService(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }
    @Transactional(readOnly = true)
    public List<Book> fetchBooksFromAuthor(Long id){
        return bookRepository.getBooksByAuthorId(id);
    }
    @Transactional(readOnly = true)
    public Book fetchBook(Long id){
        Book book = bookRepository.findById(id).orElseThrow();
        return book.getNextBook();
    }
    @Transactional(readOnly = true)
    public Book fetchCheapestBook(Long id){
        Author author = authorRepository.findById(id).orElseThrow();
        return author.getCheapestBook();
    }
}
