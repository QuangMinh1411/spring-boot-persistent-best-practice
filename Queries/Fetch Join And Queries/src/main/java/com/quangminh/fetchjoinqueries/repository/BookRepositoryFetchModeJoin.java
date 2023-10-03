package com.quangminh.fetchjoinqueries.repository;

import com.quangminh.fetchjoinqueries.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepositoryFetchModeJoin extends JpaRepository<Book,Long>, JpaSpecificationExecutor<Book> {
}
