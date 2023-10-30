package com.quangminh.databasetrigger.repository;

import com.quangminh.databasetrigger.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}