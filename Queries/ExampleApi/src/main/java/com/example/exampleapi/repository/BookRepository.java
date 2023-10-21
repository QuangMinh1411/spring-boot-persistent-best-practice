package com.example.exampleapi.repository;

import com.example.exampleapi.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface BookRepository extends JpaRepository<Book, Long>, QueryByExampleExecutor<Book> {
}