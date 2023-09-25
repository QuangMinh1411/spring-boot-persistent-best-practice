package com.quangminh.paginationrownumber.repository;

import com.quangminh.paginationrownumber.dto.AuthorDto;
import com.quangminh.paginationrownumber.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    @Query(value = "SELECT * FROM (SELECT name, age, COUNT(*) OVER() AS total, "
            + "ROW_NUMBER() OVER (ORDER BY age) AS row_num FROM author) AS a "
            + "WHERE row_num BETWEEN ?1 AND ?2",
            nativeQuery = true)
    List<AuthorDto> fetchPage(int start, int end);
}