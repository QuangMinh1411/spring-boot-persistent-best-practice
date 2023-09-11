package com.quangminh.p6spy.repository;

import com.quangminh.p6spy.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    @Transactional(readOnly=true)
    public Author findByName(String name);
}