package com.quangminh.jointablerepository.repository;

import com.quangminh.jointablerepository.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}