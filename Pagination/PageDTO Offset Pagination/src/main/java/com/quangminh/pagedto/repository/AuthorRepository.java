package com.quangminh.pagedto.repository;

import com.quangminh.pagedto.dto.AuthorDto;
import com.quangminh.pagedto.entity.Author;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    @Query(value = "SELECT name, age, COUNT(*) OVER() AS total FROM author",
            nativeQuery = true)
    List<AuthorDto> fetchAll(Pageable pageable);

    @Query(value = "SELECT name, age, COUNT(*) OVER() AS total FROM author ORDER BY ?1 LIMIT ?2, ?3",
            nativeQuery = true)
    List<AuthorDto> fetchAllWithTotal(String critical,int page, int size);
}