package com.quangminh.keysetpagination.repository;

import com.quangminh.keysetpagination.AuthorDto;
import com.quangminh.keysetpagination.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
public interface AuthorRepository extends JpaRepository<Author, Long> {
    @Query(value = "SELECT * FROM author AS a WHERE a.id < ?1 ORDER BY a.id DESC LIMIT ?2",
            nativeQuery = true)
    List<Author> fetchAll(long id, int limit);

    @Query(value = "SELECT name, age FROM author AS a WHERE a.id < ?1 ORDER BY a.id DESC LIMIT ?2",
            nativeQuery = true)
    List<AuthorDto> fetchAllDto(long id, int limit);
}