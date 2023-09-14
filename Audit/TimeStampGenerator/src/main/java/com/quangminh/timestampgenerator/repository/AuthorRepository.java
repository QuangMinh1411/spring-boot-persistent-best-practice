package com.quangminh.timestampgenerator.repository;

import com.quangminh.timestampgenerator.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    public Author findByName(String name);
}