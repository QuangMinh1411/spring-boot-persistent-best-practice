package com.quangminh.singletableinheritance.service;

import com.quangminh.singletableinheritance.entity.Author;
import com.quangminh.singletableinheritance.entity.Book;
import com.quangminh.singletableinheritance.entity.Ebook;
import com.quangminh.singletableinheritance.entity.Paperback;
import com.quangminh.singletableinheritance.repository.AuthorRepository;
import com.quangminh.singletableinheritance.repository.BookRepository;
import com.quangminh.singletableinheritance.repository.EbookRepository;
import com.quangminh.singletableinheritance.repository.PaperbackRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookstoreService {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PaperbackRepository paperbackRepository;
    private final EbookRepository ebookRepository;

    public BookstoreService(AuthorRepository authorRepository,
                            BookRepository bookRepository,
                            PaperbackRepository paperbackRepository,
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

        Paperback paperback = new Paperback();
        paperback.setIsbn("002-AT");
        paperback.setTitle("The beatles anthology");
        paperback.setSizeIn("7.5 x 1.3 x 9.2");
        paperback.setWeightLbs("2.7");

        Ebook ebook = new Ebook();
        ebook.setIsbn("003-AT");
        ebook.setTitle("Anthology myths");
        ebook.setFormat("kindle");

        author.addBook(book); // use addBook() helper
        author.addBook(paperback);
        author.addBook(ebook);

        authorRepository.save(author);
    }

    public void fetchBookByTitle() {
        Book book1 = bookRepository.findByTitle("The book of swords");
        System.out.println(book1); // this is a Book

        Book book2 = bookRepository.findByTitle("The beatles anthology");
        System.out.println(book2); // this is a Paperback

        Book book3 = bookRepository.findByTitle("Anthology myths");
        System.out.println(book3); // this is an Ebook
    }

    public void fetchPaperback() {
        Paperback p1 = paperbackRepository.findByTitle("The book of swords"); // this is a Book
        System.out.println(p1); // prints null

        Paperback p2 = paperbackRepository.findByTitle("The beatles anthology"); // this is a Paperback
        System.out.println(p2);
    }

    public void fetchEbook() {
        Ebook e1 = ebookRepository.findByTitle("The book of swords"); // this is a Book
        System.out.println(e1); // prints null

        Ebook e2 = ebookRepository.findByTitle("Anthology myths"); // this is a Ebook
        System.out.println(e2);
    }

    public void fetchBooksByAuthorId() {
        List<Book> books = bookRepository.fetchBooksByAuthorId(1L);
        System.out.println(books);
    }

    @Transactional(readOnly = true)
    public void fetchAuthorAndBooksLazy() {
        Author author = authorRepository.findByName("Alicia Tom");
        System.out.println(author + " | " + author.getBooks());
    }

    @Transactional(readOnly = true)
    public void fetchAuthorAndBooksEager() {
        Author author = authorRepository.findAuthor();
        System.out.println(author + " | " + author.getBooks());
    }
}
