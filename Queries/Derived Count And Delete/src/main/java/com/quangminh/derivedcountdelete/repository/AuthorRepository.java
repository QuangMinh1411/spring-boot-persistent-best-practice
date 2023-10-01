package com.quangminh.derivedcountdelete.repository;

import com.quangminh.derivedcountdelete.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
public interface AuthorRepository extends JpaRepository<Author, Long> {
    long countByGenre(String genre);
    @Transactional
    long deleteByGenre(String genre);

    @Transactional
    List<Author> removeByGenre(String genre);
}