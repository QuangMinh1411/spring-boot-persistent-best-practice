package com.quangminh.joinfetchrepair.repository;

import com.quangminh.joinfetchrepair.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}