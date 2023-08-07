package com.minhquang.streammysql.repository;

import com.minhquang.streammysql.entity.Book;
import com.minhquang.streammysql.wrapper.Books;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
    Books findBy();
}