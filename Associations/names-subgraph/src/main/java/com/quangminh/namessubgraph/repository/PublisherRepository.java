package com.quangminh.namessubgraph.repository;

import com.quangminh.namessubgraph.entity.Publisher;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
public interface PublisherRepository extends JpaRepository<Publisher,Long>, JpaSpecificationExecutor<Publisher> {

    @EntityGraph(attributePaths = {"books.author"},type = EntityGraph.EntityGraphType.FETCH)
    @Override
    public List<Publisher> findAll();
    @EntityGraph(attributePaths = {"books.author"},type = EntityGraph.EntityGraphType.FETCH)
    public List<Publisher> findByIdLessThanOrderByCompanyDesc(long id);
    @EntityGraph(attributePaths = {"books.author"},type = EntityGraph.EntityGraphType.FETCH)
    @Override
    public List<Publisher> findAll(Specification<Publisher> spec);
    @EntityGraph(attributePaths = {"books.author"},type = EntityGraph.EntityGraphType.FETCH)
    @Query("select p from Publisher p where p.id>?1 and p.id<?2")
    public List<Publisher> fetchAllIdBetween(int low,int high);
}
