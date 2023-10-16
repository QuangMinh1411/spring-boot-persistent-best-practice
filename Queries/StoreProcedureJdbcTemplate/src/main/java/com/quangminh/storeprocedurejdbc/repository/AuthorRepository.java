package com.quangminh.storeprocedurejdbc.repository;

import com.quangminh.storeprocedurejdbc.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}