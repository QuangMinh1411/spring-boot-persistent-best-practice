package com.quangminh.savemerge.repository;

import com.quangminh.savemerge.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}