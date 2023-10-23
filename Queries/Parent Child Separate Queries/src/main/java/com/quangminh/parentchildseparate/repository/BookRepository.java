package com.quangminh.parentchildseparate.repository;

import com.quangminh.parentchildseparate.entity.Author;
import com.quangminh.parentchildseparate.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
public interface BookRepository extends JpaRepository<Book, Long> {
    @Query("SELECT b FROM Book b WHERE b.author = ?1")
    List<Book> fetchByAuthor(Author author);

    List<Book> findByAuthor(Author author);
}