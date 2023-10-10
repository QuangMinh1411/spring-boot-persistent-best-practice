package com.quangminh.subquerywhere.repository;

import com.quangminh.subquerywhere.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    @Transactional(readOnly = true)
    @Query("SELECT a FROM Author a WHERE a.id IN "
            + "(SELECT b.authorId FROM Bestseller b)")
    List<Author> fetchTheBest();
}