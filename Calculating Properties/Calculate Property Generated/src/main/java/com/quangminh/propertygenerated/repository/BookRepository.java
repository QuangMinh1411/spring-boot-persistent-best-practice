package com.quangminh.propertygenerated.repository;

import com.quangminh.propertygenerated.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
    Book findByTitle(String title);
}