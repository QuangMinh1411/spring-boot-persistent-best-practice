package com.quangminh.enumpostgres.repository;

import com.quangminh.enumpostgres.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}