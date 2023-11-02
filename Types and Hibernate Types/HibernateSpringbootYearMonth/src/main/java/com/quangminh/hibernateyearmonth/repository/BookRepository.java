package com.quangminh.hibernateyearmonth.repository;

import com.quangminh.hibernateyearmonth.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
    public Book findByTitle(String title);
}