package com.quangminh.topnrowsgroup.repository;

import com.quangminh.topnrowsgroup.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    @Transactional(readOnly = true)
    @Query(value = "WITH sales AS (SELECT *, ROW_NUMBER() "
            + "OVER (PARTITION BY name ORDER BY sold DESC) AS row_num"
            + " FROM author) SELECT * FROM sales WHERE row_num <= ?1",
            nativeQuery = true)
    List<Author> fetchTopBySales(int top);
}