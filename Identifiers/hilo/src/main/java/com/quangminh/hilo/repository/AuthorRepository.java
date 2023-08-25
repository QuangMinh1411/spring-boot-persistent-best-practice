package com.quangminh.hilo.repository;

import com.quangminh.hilo.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}