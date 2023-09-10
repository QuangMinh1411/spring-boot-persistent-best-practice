package com.quangminh.jpqlfunctionparam.repository;

import com.quangminh.jpqlfunctionparam.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

public interface BookRepository extends JpaRepository<Book, Long> {
    @Transactional(readOnly = true)
    @Query(value = "SELECT concat_ws(' ',b.title, ?1, b.price, ?2) FROM Book b WHERE b.id = ?3")
    String fetchTitleAndPrice(String symbol, Instant instant,Long id);

    @Transactional(readOnly = true)
    @Query(value = "SELECT b FROM Book b WHERE b.isbn=function('concat_ws','-',?1,?2)")
    Book fetchByIsbn(String code,String author);
}