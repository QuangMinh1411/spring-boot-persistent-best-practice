package com.quangminh.transactionalreadonly.repository;

import com.quangminh.transactionalreadonly.dto.AuthorDto;
import com.quangminh.transactionalreadonly.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    Author findFirstByGenre(String genre);
    AuthorDto findTopByGenre(String genre);
}