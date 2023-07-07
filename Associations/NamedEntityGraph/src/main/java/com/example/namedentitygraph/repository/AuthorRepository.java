package com.example.namedentitygraph.repository;

import com.example.namedentitygraph.entity.Author;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author,Long>, JpaSpecificationExecutor<Author> {

    @EntityGraph(attributePaths = {"books"},
    type = EntityGraph.EntityGraphType.FETCH)
    @Override
    public List<Author> findAll();

    @EntityGraph(value = "author-books-graph",type = EntityGraph.EntityGraphType.FETCH)

    public List<Author> findByAgeLessThanOrderByNameDesc(int age);


    @Override
    @EntityGraph(value = "author-books-graph",type = EntityGraph.EntityGraphType.FETCH)
    public List<Author> findAll(Specification spec);

    @EntityGraph(value = "author-books-graph",type = EntityGraph.EntityGraphType.FETCH)
    @Query("select a from Author a where a.age>?1 and a.age<?2")
    public List<Author> fetchAllAgeBetween(int low,int high);
}
