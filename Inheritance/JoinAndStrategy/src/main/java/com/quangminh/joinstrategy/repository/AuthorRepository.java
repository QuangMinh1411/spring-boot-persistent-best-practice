package com.quangminh.joinstrategy.repository;

import com.quangminh.joinstrategy.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}