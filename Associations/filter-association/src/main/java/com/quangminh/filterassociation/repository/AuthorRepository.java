package com.quangminh.filterassociation.repository;

import com.quangminh.filterassociation.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author,Long> {
}
