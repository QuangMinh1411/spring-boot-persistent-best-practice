package com.quangminh.onetoonemapsid.service;

import com.quangminh.onetoonemapsid.entity.Author;
import com.quangminh.onetoonemapsid.entity.Book;
import com.quangminh.onetoonemapsid.repository.AuthorRepository;
import com.quangminh.onetoonemapsid.repository.BookRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BookService {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    @Transactional
    public Book newBookOfAuthor(Long authorId,Book book) {

        Author author = authorRepository.findById(authorId).orElseThrow();

        // this will set the id of the book as the id of the author
        book.setAuthor(author);

       return bookRepository.save(book);
    }

    @Transactional(readOnly = true)
    public Book fetchBookByAuthorId(Long id) {

        Author author = authorRepository.findById(id).orElseThrow();

        return bookRepository.findById(author.getId()).orElseThrow();
    }


}


