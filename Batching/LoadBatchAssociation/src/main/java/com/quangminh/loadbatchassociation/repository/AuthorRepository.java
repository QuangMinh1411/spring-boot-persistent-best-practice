package com.quangminh.loadbatchassociation.repository;

import com.quangminh.loadbatchassociation.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}