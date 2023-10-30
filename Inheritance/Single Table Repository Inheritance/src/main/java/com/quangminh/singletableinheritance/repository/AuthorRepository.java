package com.quangminh.singletableinheritance.repository;

import com.quangminh.singletableinheritance.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}