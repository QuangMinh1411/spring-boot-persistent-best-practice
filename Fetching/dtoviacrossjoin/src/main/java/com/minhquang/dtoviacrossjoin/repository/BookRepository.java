package com.minhquang.dtoviacrossjoin.repository;

import com.minhquang.dtoviacrossjoin.entiry.Book;
import com.minhquang.dtoviacrossjoin.projection.BookTitleAndFormatType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
public interface BookRepository extends JpaRepository<Book, Long> {
    // Cross join books and formats (JPQL)
    @Query(value = "SELECT b.title AS title, f.formatType AS formatType "
            + "FROM Book b, Format f")
    List<BookTitleAndFormatType> findBooksAndFormatsJpql();

    // Cross join books and formats (SQL)
    @Query(value = "SELECT b.title AS title, f.format_type AS formatType "
            + "FROM book b CROSS JOIN format f",
            nativeQuery = true)
    List<BookTitleAndFormatType> findBooksAndFormatsSql();
}