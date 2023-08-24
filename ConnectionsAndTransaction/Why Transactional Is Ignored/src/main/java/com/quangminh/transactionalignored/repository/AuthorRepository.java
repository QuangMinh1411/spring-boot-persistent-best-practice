package com.quangminh.transactionalignored.repository;

import com.quangminh.transactionalignored.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}