package com.quangminh.mergecollection.repository;

import com.quangminh.mergecollection.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    @Query(value = "SELECT b FROM Book b JOIN b.author a WHERE a.name = ?1")
    List<Book> booksOfAuthor(String name);
}