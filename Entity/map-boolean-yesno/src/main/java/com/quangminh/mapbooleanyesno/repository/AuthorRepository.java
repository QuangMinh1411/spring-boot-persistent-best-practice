package com.quangminh.mapbooleanyesno.repository;

import com.quangminh.mapbooleanyesno.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Long> {
    Author findByName(String name);
}
