package com.quangminh.log4jdbc.repository;

import com.quangminh.log4jdbc.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    @Transactional(readOnly=true)
    public Author findByName(String name);
}