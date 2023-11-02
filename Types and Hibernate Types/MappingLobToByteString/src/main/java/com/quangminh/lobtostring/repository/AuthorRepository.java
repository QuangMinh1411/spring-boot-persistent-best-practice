package com.quangminh.lobtostring.repository;

import com.quangminh.lobtostring.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    public Author findByName(String name);
}