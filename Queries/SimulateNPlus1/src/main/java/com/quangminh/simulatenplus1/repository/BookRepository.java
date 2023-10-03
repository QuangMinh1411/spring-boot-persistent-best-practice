package com.quangminh.simulatenplus1.repository;

import com.quangminh.simulatenplus1.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}