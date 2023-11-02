package com.quangminh.mappedsuperclass.repository;

import com.quangminh.mappedsuperclass.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    @Transactional(readOnly=true)
    Author findByName(String name);
}