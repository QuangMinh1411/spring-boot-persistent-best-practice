package com.quangminh.maplobclobblob.repository;

import com.quangminh.maplobclobblob.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    public Author findByName(String name);
}