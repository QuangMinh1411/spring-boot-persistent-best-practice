package com.minhquang.dtoviacrossjoin.repository;

import com.minhquang.dtoviacrossjoin.entiry.Format;
import com.minhquang.dtoviacrossjoin.projection.BookTitleAndFormatType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FormatRepository extends JpaRepository<Format, Long> {
    // Cross join formats and books (JPQL)
    @Query(value = "SELECT b.title AS title, f.formatType AS formatType "
            + "FROM Format f, Book b")
    List<BookTitleAndFormatType> findFormatsAndBooksJpql();

    // Cross join formats and books (SQL)
    @Query(value = "SELECT b.title AS title, f.format_type AS formatType "
            + "FROM format f CROSS JOIN book b",
            nativeQuery = true)
    List<BookTitleAndFormatType> findFormatsAndBooksSql();
}