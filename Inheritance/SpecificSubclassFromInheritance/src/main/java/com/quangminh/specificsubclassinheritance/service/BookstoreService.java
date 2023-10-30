package com.quangminh.specificsubclassinheritance.service;

import com.quangminh.specificsubclassinheritance.entity.Author;
import com.quangminh.specificsubclassinheritance.entity.Book;
import com.quangminh.specificsubclassinheritance.entity.Ebook;
import com.quangminh.specificsubclassinheritance.entity.PaperBack;
import com.quangminh.specificsubclassinheritance.repository.AuthorRepository;
import com.quangminh.specificsubclassinheritance.repository.BookRepository;
import com.quangminh.specificsubclassinheritance.repository.EbookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookstoreService {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final EbookRepository ebookRepository;

    public BookstoreService(AuthorRepository authorRepository,
                            BookRepository bookRepository,
                            EbookRepository ebookRepository) {

        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.ebookRepository = ebookRepository;
    }
//    public void persistAuthorWithBooks() {
//
//        Author author = new Author();
//        author.setName("Alicia Tom");
//        author.setAge(38);
//        author.setGenre("Anthology");
//
//        Book book = new Book();
//        book.setIsbn("001-AT");
//        book.setTitle("The book of swords");
//
//        PaperBack paperback = new PaperBack();
//        paperback.setIsbn("002-AT");
//        paperback.setTitle("The beatles anthology");
//        paperback.setSizeIn("7.5 x 1.3 x 9.2");
//        paperback.setWeightLbs("2.7");
//
//        Ebook ebook = new Ebook();
//        ebook.setIsbn("003-AT");
//        ebook.setTitle("Anthology myths");
//        ebook.setFormat("kindle");
//
//        author.addBook(book); // use addBook() helper
//        author.addBook(paperback);
//        author.addBook(ebook);
//
//        authorRepository.save(author);
//    }

    public List<Ebook> findEbookByAuthorNameViaEbookRepository(String name) {
        List<Ebook> ebooks = ebookRepository.findByAuthorName(name);
//        System.out.println(ebook + " | " + (ebook instanceof Ebook));
        return ebooks;
    }

    public List<Book> findEbookByAuthorNameViaBookRepository(String name) {
        List<Book> books = bookRepository.findByAuthorName(name);
//        System.out.println(book + " | " + (book instanceof Ebook));
        return books;
    }
}
