package com.quangminh.mysqlskiplocked.repository;

import com.quangminh.mysqlskiplocked.entity.Book;
import com.quangminh.mysqlskiplocked.entity.BookStatus;
import jakarta.persistence.LockModeType;
import jakarta.persistence.QueryHint;
import org.hibernate.LockOptions;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.QueryHints;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @QueryHints({
            @QueryHint(name = "jakarta.persistence.lock.timeout", value = "" + LockOptions.SKIP_LOCKED)})
    List<Book> findTop3ByStatus(BookStatus status, Sort sort);
}