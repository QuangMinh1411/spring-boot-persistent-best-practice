package com.quangminh.entitylistener.service;

import com.quangminh.entitylistener.entity.Paper;
import com.quangminh.entitylistener.entity.Author;
import com.quangminh.entitylistener.entity.Ebook;
import com.quangminh.entitylistener.repository.AuthorRepository;
import com.quangminh.entitylistener.repository.EbookRepository;
import com.quangminh.entitylistener.repository.PaperRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookstoreService {

    private final AuthorRepository authorRepository;
    private final EbookRepository ebookRepository;
    private final PaperRepository paperRepository;

    public BookstoreService(AuthorRepository authorRepository, EbookRepository ebookRepository, PaperRepository paperRepository) {
        this.authorRepository = authorRepository;
        this.ebookRepository = ebookRepository;
        this.paperRepository = paperRepository;
    }

    @Transactional
    public void persistAuthorWithBooks() {

        Author author = new Author();
        author.setName("Alicia Tom");
        author.setAge(38);
        author.setGenre("Anthology");

        Paper paperback = new Paper();
        paperback.setIsbn("002-AT");
        paperback.setTitle("The beatles anthology");
        paperback.setSizeIn("7.5 x 1.3 x 9.2");
        paperback.setWeightLbs("2.7");
        paperback.setAuthor(author);

        Ebook ebook = new Ebook();
        ebook.setIsbn("003-AT");
        ebook.setTitle("Anthology myths");
        ebook.setFormat("kindle");
        ebook.setAuthor(author);

        authorRepository.save(author);
        paperRepository.save(paperback);
        ebookRepository.save(ebook);
    }

    @Transactional
    public void fetchAndRemovePaperback() {
        Paper paperback = paperRepository
                .findByTitle("The beatles anthology");
        paperRepository.delete(paperback);
    }

    @Transactional
    public void fetchAndRemoveEbook() {
        Ebook ebook = ebookRepository
                .findByTitle("Anthology myths");
        ebookRepository.delete(ebook);
    }
}
