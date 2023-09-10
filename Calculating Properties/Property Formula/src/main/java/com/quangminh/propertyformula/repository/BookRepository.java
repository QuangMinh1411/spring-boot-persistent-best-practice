package com.quangminh.propertyformula.repository;

import com.quangminh.propertyformula.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}