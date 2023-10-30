package com.quangminh.singletableinheritance.service;

import com.quangminh.singletableinheritance.entity.Author;
import com.quangminh.singletableinheritance.entity.Book;
import com.quangminh.singletableinheritance.entity.Ebook;
import com.quangminh.singletableinheritance.entity.PaperBack;
import com.quangminh.singletableinheritance.repository.AuthorRepository;
import com.quangminh.singletableinheritance.repository.BookRepository;
import com.quangminh.singletableinheritance.repository.EbookRepository;
import com.quangminh.singletableinheritance.repository.PaperBackRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookstoreService {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PaperBackRepository paperbackRepository;
    private final EbookRepository ebookRepository;

    public BookstoreService(AuthorRepository authorRepository,
                            BookRepository bookRepository,
                            PaperBackRepository paperbackRepository,
                            EbookRepository ebookRepository) {

        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.paperbackRepository = paperbackRepository;
        this.ebookRepository = ebookRepository;
    }
    public void persistAuthorWithBooks() {

        Author author = new Author();
        author.setName("Alicia Tom");
        author.setAge(38);
        author.setGenre("Anthology");

        Book book = new Book();
        book.setIsbn("001-AT");
        book.setTitle("The book of swords");

        PaperBack paperback = new PaperBack();
        paperback.setIsbn("002-AT");
        paperback.setTitle("The beatles anthology");
        paperback.setSizeIn("7.5 x 1.3 x 9.2");
        paperback.setWeightLbs("2.7");

        Ebook ebook = new Ebook();
        ebook.setIsbn("003-AT");
        ebook.setTitle("Anthology myths");
        ebook.setFormat("kindle");

        author.addBook(book);
        author.addBook(paperback);
        author.addBook(ebook);

        authorRepository.save(author);
    }

    @Transactional(readOnly = true)
    public void fetchBookByTitle() {
        Book book = bookRepository.findByTitle("The book of swords");
        System.out.println(book);

        PaperBack paperback = paperbackRepository.findByTitle("The beatles anthology");
        System.out.println(paperback);

        Ebook ebook = ebookRepository.findByTitle("Anthology myths");
        System.out.println(ebook);
    }

    @Transactional(readOnly = true)
    public void fetchBookByIsbn() {
        Book book = bookRepository.fetchByIsbn("001-AT");
        System.out.println(book);

        PaperBack paperback = paperbackRepository.fetchByIsbn("002-AT");
        System.out.println(paperback);

        Ebook ebook = ebookRepository.fetchByIsbn("003-AT");
        System.out.println(ebook);
    }
}
