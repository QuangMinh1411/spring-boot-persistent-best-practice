package com.quangminh.springaudit.repository;

import com.quangminh.springaudit.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    Author findByName(String name);
}