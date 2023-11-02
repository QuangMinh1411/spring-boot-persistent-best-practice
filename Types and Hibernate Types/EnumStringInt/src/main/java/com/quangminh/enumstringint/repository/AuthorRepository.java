package com.quangminh.enumstringint.repository;

import com.quangminh.enumstringint.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}