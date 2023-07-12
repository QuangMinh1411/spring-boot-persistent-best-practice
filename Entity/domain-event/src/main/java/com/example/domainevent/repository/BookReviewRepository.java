package com.example.domainevent.repository;

import com.example.domainevent.entity.BookReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface BookReviewRepository extends JpaRepository<BookReview,Long> {
    @Transactional
    BookReview findByEmail(String email);
}
