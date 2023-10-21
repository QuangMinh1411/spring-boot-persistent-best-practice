package com.quangminh.specqueryfetchjoin.repository;

import com.quangminh.specqueryfetchjoin.entity.Author;
import jakarta.persistence.QueryHint;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long>,
        JpaSpecificationExecutor<Author> {
    @Transactional(readOnly = true)
    @Query(value = "SELECT a.id FROM Author a WHERE a.genre = ?1")
    Page<Long> fetchPageOfIdsByGenre(String genre, Pageable pageable);

    @Override
    public List<Author> findAll(Specification<Author> spec);

    @Override
    public Page<Author> findAll(Specification<Author> spec, Pageable pageable);
}