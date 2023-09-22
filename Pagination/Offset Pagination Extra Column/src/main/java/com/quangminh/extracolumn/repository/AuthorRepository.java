package com.quangminh.extracolumn.repository;

import com.quangminh.extracolumn.entity.Author;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    @Transactional
    @Query(value = "SELECT id, name, age, genre, COUNT(*) OVER() AS total FROM author",
            nativeQuery = true)
    List<Author> fetchAll(Pageable pageable);
    @Query(value = "SELECT id, name, age, genre, COUNT(*) OVER() AS total "
            + "FROM author ORDER BY age LIMIT ?1, ?2",
            nativeQuery = true)
    List<Author> fetchAllList(int page, int size);
}