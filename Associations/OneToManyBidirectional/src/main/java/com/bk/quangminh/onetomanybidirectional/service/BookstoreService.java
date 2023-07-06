package com.bk.quangminh.onetomanybidirectional.service;

import com.bk.quangminh.onetomanybidirectional.entity.Author;
import com.bk.quangminh.onetomanybidirectional.entity.Book;
import com.bk.quangminh.onetomanybidirectional.repository.AuthorRepository;
import com.bk.quangminh.onetomanybidirectional.repository.BookRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookstoreService {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public void insertAuthorWithBooks(Long authorId, Book book){
        Author author = authorRepository.findById(authorId).orElse(null);
        if(author!=null){
            author.addBook(book);
            authorRepository.save(author);
        }

    }

    @Transactional
    public void deleteBookOfAuthor(String authorName){
        Author author = authorRepository.findAuthorByName(authorName).orElse(null);
        if(author!=null){
            author.removeBooks();
            authorRepository.save(author);
        }

    }

    public List<Book> findBooksByAuthor(String name){
        return bookRepository.findBooksByAuthor(name);
    }

}
