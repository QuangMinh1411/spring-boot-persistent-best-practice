package com.minhquang.unrelatedentities.repository;

import com.minhquang.unrelatedentities.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface BookRepository extends JpaRepository<Book, Long> {
    @Transactional(readOnly = true)
    Book findByTitle(String title);
}