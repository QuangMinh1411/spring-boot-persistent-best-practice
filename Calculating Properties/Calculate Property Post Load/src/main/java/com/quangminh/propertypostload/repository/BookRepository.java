package com.quangminh.propertypostload.repository;

import com.quangminh.propertypostload.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}