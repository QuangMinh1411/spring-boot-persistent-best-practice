package com.quangminh.joinfetch.repository;

import com.quangminh.joinfetch.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    @Transactional(readOnly = true)
    @Query("select b from Book b join fetch b.author where b.isbn=?1")
    Book fetchBookWithAuthorByIsbn(String isbn);

    // INNER JOIN BAD
    @Transactional(readOnly = true)
    @Query(value = "SELECT b FROM Book b INNER JOIN b.author a")
    List<Book> fetchBooksAuthorsInnerJoinBad();

    // INNER JOIN GOOD
    @Transactional(readOnly = true)
    @Query(value = "SELECT b, a FROM Book b INNER JOIN b.author a")
    List<Book> fetchBooksAuthorsInnerJoinGood();

    // JOIN FETCH
    @Transactional(readOnly = true)
    @Query(value = "SELECT b FROM Book b JOIN FETCH b.author a")
    List<Book> fetchBooksAuthorsJoinFetch();
}