package com.quangminh.joinstrategy.repository;

import com.quangminh.joinstrategy.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}