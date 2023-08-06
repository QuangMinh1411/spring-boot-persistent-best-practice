package com.minhquang.dtoviacrossjoin.service;

import com.minhquang.dtoviacrossjoin.projection.BookTitleAndFormatType;
import com.minhquang.dtoviacrossjoin.repository.BookRepository;
import com.minhquang.dtoviacrossjoin.repository.FormatRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookstoreService {

    private final BookRepository bookRepository;
    private final FormatRepository formatRepository;

    public BookstoreService(BookRepository bookRepository, FormatRepository formatRepository) {
        this.bookRepository = bookRepository;
        this.formatRepository = formatRepository;
    }

    // Cross join books and formats (JPQL)
    public List<BookTitleAndFormatType> fetchBooksAndFormatsJpql() {
        return bookRepository.findBooksAndFormatsJpql();
    }

    // Cross join books and formats (SQL)
    public List<BookTitleAndFormatType> fetchBooksAndFormatsSql() {
        return bookRepository.findBooksAndFormatsSql();
    }

    // Cross join formats and books (JPQL)
    public List<BookTitleAndFormatType> fetchFormatsAndBooksJpql() {
        return formatRepository.findFormatsAndBooksJpql();
    }

    // Cross join formats and books (SQL)
    public List<BookTitleAndFormatType> fetchFormatsAndBooksSql() {
        return formatRepository.findFormatsAndBooksSql();
    }
}
