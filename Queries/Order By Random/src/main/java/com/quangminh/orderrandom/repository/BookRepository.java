package com.quangminh.orderrandom.repository;

import com.quangminh.orderrandom.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    @Transactional(readOnly=true)
    @Query("SELECT b FROM Book b ORDER BY RAND()")
    List<Book> fetchOrderByRnd();
}