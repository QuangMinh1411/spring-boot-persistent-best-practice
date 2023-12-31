package com.quangminh.naturalid.service;

import com.quangminh.naturalid.entity.Book;
import com.quangminh.naturalid.repository.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class BookstoreService {
    private final BookRepository bookRepository;

    public BookstoreService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Transactional
    public void persistTwoBooks() {

        Book ar = new Book();
        ar.setIsbn("001-AR");
        ar.setTitle("Ancient Rome");
        ar.setPrice(25);
        // ar.setSku(1L);

        Book rh = new Book();
        rh.setIsbn("001-RH");
        rh.setTitle("Rush Hour");
        rh.setPrice(31);
        // rh.setSku(2L);

        bookRepository.save(ar);
        bookRepository.save(rh);
    }

    public Book fetchFirstBookByNaturalId() {

        // find the first book by a single natural id
        Optional<Book> foundArBook
                = bookRepository.findBySimpleNaturalId("001-AR");

        // find first book by two natural ids (for running this code simply
        // uncomment the "sku" field in the Book entity and the below lines; comment lines 44 and 45)
        // Map<String, Object> ids = new HashMap<>();
        // ids.put("sku", 1L);
        // ids.put("isbn", "001-AR");
        // Optional<Book> foundArBook = bookRepository.findByNaturalId(ids);

        return foundArBook.orElseThrow();
    }
}
