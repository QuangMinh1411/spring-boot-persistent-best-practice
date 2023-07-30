package com.quangminh.dtoconstructor.repository;

import com.quangminh.dtoconstructor.dto.AuthorDto;
import com.quangminh.dtoconstructor.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    @Transactional(readOnly = true)
    List<AuthorDto> findByGenre(String genre);
}