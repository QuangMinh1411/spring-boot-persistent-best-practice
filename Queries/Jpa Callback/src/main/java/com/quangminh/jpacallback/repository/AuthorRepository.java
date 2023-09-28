package com.quangminh.jpacallback.repository;

import com.quangminh.jpacallback.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}