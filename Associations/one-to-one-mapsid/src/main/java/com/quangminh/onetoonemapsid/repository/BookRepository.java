package com.quangminh.onetoonemapsid.repository;

import com.quangminh.onetoonemapsid.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {
}
