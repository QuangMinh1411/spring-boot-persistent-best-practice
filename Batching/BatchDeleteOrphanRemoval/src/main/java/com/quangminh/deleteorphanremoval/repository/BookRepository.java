package com.quangminh.deleteorphanremoval.repository;

import com.quangminh.deleteorphanremoval.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

}