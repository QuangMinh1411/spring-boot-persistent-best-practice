package com.quangminh.fetchjoinqueries.repository;

import com.quangminh.fetchjoinqueries.entity.Book;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface BookRepositoryEntityGraph extends JpaRepository<Book,Long>, JpaSpecificationExecutor<Book> {
    @Override
    @EntityGraph(attributePaths = {"author.publisher"})
    public Optional<Book> findById(Long id);

    @Override
    @EntityGraph(attributePaths = {"author.publisher"})
    public List<Book> findAll();

    @Override
    @EntityGraph(attributePaths = {"author.publisher"})
    public List<Book> findAll(Specification<Book> spec);
}
