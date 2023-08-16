package com.quangminh.deleteorphanremoval.repository;

import com.quangminh.deleteorphanremoval.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    @Query(value = "SELECT DISTINCT a FROM Author a JOIN FETCH a.books b WHERE a.age < ?1")
    List<Author> fetchAuthorsAndBooks(int age);
}