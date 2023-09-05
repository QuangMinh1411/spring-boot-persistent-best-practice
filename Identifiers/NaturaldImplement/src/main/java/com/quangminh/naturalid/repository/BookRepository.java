package com.quangminh.naturalid.repository;

import com.quangminh.naturalid.entity.Book;
import com.quangminh.naturalid.naturalId.NaturalRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository<T,ID> extends NaturalRepository<Book, Long> {
}