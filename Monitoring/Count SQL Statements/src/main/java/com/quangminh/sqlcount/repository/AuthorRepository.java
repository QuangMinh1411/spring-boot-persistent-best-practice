package com.quangminh.sqlcount.repository;

import com.quangminh.sqlcount.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}