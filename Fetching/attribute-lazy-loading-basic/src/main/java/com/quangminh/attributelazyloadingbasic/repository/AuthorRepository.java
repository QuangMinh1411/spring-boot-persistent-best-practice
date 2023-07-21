package com.quangminh.attributelazyloadingbasic.repository;

import com.quangminh.attributelazyloadingbasic.dto.AuthorDto;
import com.quangminh.attributelazyloadingbasic.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author,Long> {
    @Transactional(readOnly = true)
    List<Author> findByAgeGreaterThanEqual(int age);
    @Transactional(readOnly = true)
    @Query("select a.name AS name,a.avatar AS avatar from Author a where a.age>=?1")
    List<AuthorDto> findDtoByAgeGreaterThanEqual(int age);
}
