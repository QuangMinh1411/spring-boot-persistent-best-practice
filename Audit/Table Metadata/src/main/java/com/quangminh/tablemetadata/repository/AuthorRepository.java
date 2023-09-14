package com.quangminh.tablemetadata.repository;

import com.quangminh.tablemetadata.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}