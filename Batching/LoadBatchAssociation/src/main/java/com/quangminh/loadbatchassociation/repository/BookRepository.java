package com.quangminh.loadbatchassociation.repository;

import com.quangminh.loadbatchassociation.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}