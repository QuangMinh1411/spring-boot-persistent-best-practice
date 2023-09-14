package com.quangminh.schemasql.repository;

import com.quangminh.schemasql.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}