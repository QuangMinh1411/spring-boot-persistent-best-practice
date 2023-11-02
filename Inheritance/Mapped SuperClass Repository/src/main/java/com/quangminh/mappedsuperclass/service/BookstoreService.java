package com.quangminh.mappedsuperclass.service;

import com.quangminh.mappedsuperclass.entity.Book;
import com.quangminh.mappedsuperclass.entity.Ebook;
import com.quangminh.mappedsuperclass.entity.Paperback;
import com.quangminh.mappedsuperclass.repository.AuthorRepository;
import com.quangminh.mappedsuperclass.repository.EbookRepository;
import com.quangminh.mappedsuperclass.repository.PaperbackRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookstoreService {

    private final AuthorRepository authorRepository;
    private final EbookRepository ebookRepository;
    private final PaperbackRepository paperbackRepository;

    public BookstoreService(AuthorRepository authorRepository, EbookRepository ebookRepository, PaperbackRepository paperbackRepository) {
        this.authorRepository = authorRepository;
        this.ebookRepository = ebookRepository;
        this.paperbackRepository = paperbackRepository;
    }
    @Transactional(readOnly = true)
    public Book fetchBookByTitle(String title) {
        Paperback paperback = paperbackRepository.findByTitle(title);
        System.out.println(paperback);

        Ebook ebook = ebookRepository.findByTitle(title);
        System.out.println(ebook);
        return paperback!=null?paperback:ebook;
    }

    @Transactional(readOnly = true)
    public Book fetchBookByIsbn(String isbn) {
        Paperback paperback = paperbackRepository.fetchByIsbn(isbn);
        System.out.println(paperback);

        Ebook ebook = ebookRepository.fetchByIsbn(isbn);
        System.out.println(ebook);
        return paperback!=null?paperback:ebook;
    }
}
