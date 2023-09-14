package com.quangminh.spenvers.repository;

import com.quangminh.spenvers.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}