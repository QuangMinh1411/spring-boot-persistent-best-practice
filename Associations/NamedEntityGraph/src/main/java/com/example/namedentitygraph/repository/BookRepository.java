package com.example.namedentitygraph.repository;

import com.example.namedentitygraph.entity.Book;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Long> {

    @Transactional
    @EntityGraph(value = "books-author-graph",type = EntityGraph.EntityGraphType.FETCH)
    @Override
    public List<Book> findAll();
}
