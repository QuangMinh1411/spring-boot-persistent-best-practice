package com.quangminh.tableperclass.repository;

import com.quangminh.tableperclass.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}