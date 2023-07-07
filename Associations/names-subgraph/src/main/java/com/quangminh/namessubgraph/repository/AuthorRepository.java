package com.quangminh.namessubgraph.repository;

import com.quangminh.namessubgraph.entity.Author;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
public interface AuthorRepository extends JpaRepository<Author,Long> , JpaSpecificationExecutor<Author> {
    @EntityGraph(value = "author-books-publisher-graph",
    type = EntityGraph.EntityGraphType.FETCH)
    @Override
    public List<Author> findAll();
    @EntityGraph(value = "author-books-publisher-graph",
    type = EntityGraph.EntityGraphType.FETCH)
    public List<Author> findByAgeLessThanOrderByNameDesc(int age);

    @Override
    @EntityGraph(value = "author-books-publisher-graph",type = EntityGraph.EntityGraphType.FETCH)
    public List<Author> findAll(Specification<Author> spec);

    @EntityGraph(value = "author-books-publisher-graph",type = EntityGraph.EntityGraphType.FETCH)
    @Query("select a from Author a where a.age>?1 and a.age<?2")
    public List<Author> fetchAllAgeBetween(int low,int high);
}
