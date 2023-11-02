package com.quangminh.enumattributeconverter.repository;

import com.quangminh.enumattributeconverter.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}