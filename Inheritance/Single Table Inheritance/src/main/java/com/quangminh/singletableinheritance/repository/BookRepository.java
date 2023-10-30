package com.quangminh.singletableinheritance.repository;

import com.quangminh.singletableinheritance.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    @Transactional(readOnly = true)
    Book findByTitle(String title);

    @Transactional(readOnly = true)
    @Query("SELECT b FROM Book b WHERE b.author.id = ?1")
    List<Book> fetchBooksByAuthorId(Long authorId);
}