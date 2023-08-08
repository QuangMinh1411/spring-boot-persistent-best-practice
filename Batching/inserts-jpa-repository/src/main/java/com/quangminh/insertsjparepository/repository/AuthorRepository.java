package com.quangminh.insertsjparepository.repository;

import com.quangminh.insertsjparepository.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}