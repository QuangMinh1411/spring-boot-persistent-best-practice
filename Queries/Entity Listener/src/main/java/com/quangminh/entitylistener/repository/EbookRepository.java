package com.quangminh.entitylistener.repository;

import com.quangminh.entitylistener.entity.Ebook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface EbookRepository extends JpaRepository<Ebook, Long> {
    @Transactional(readOnly = true)
    Ebook findByTitle(String title);

    @Transactional(readOnly = true)
    @Query("SELECT e FROM Ebook e JOIN FETCH e.author")
    Ebook fetchByAuthorId(Long id);
}