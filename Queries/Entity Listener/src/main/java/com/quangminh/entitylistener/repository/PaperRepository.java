package com.quangminh.entitylistener.repository;

import com.quangminh.entitylistener.entity.Paper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface PaperRepository extends JpaRepository<Paper, Long> {
    @Transactional(readOnly = true)
    Paper findByTitle(String title);

    @Transactional(readOnly = true)
    @Query("SELECT e FROM Paper e JOIN FETCH e.author")
    Paper fetchByAuthorId(Long id);
}