package com.quangminh.joinformual.repository;

import com.quangminh.joinformual.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}