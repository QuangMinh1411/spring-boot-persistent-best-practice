package com.quangminh.specificsubclassinheritance.repository;

import com.quangminh.specificsubclassinheritance.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}