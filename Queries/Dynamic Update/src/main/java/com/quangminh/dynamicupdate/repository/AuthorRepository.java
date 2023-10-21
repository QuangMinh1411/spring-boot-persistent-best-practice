package com.quangminh.dynamicupdate.repository;

import com.quangminh.dynamicupdate.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}