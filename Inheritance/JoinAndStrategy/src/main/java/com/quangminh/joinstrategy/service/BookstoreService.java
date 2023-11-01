package com.quangminh.joinstrategy.service;

import com.quangminh.joinstrategy.entity.Author;
import com.quangminh.joinstrategy.entity.Book;
import com.quangminh.joinstrategy.entity.Ebook;
import com.quangminh.joinstrategy.entity.Paperback;
import com.quangminh.joinstrategy.repository.AuthorRepository;
import com.quangminh.joinstrategy.visitor.Visitor;
import org.springframework.stereotype.Service;

@Service
public class BookstoreService {
    private final AuthorRepository authorRepository;
    private final DeliverService deliverService;
    private final VisitorService visitorService;

    public BookstoreService(AuthorRepository authorRepository, DeliverService deliverService, VisitorService visitorService) {
        this.authorRepository = authorRepository;
        this.deliverService = deliverService;
        this.visitorService = visitorService;
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

        //   author.addBook(book); // use addBook() helper
        author.addBook(paperback);
        author.addBook(ebook);

        authorRepository.save(author);
    }

    public void applyDelivers() {
        deliverService.process();
    }

    public void persistAuthorWithBooksinVisitor() {

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

        //   author.addBook(book); // use addBook() helper
        author.addBook(paperback);
        author.addBook(ebook);

        authorRepository.save(author);
    }

    public void applyVisitor(Class<? extends Visitor> clazzVisitor) {
        visitorService.accept(clazzVisitor);
    }
}
