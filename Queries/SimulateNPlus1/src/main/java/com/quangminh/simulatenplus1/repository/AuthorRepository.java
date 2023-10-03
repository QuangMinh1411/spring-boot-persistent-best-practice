package com.quangminh.simulatenplus1.repository;

import com.quangminh.simulatenplus1.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}