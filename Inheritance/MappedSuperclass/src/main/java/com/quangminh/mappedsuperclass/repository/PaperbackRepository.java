package com.quangminh.mappedsuperclass.repository;

import com.quangminh.mappedsuperclass.entity.Paperback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface PaperbackRepository extends JpaRepository<Paperback, Long> {
    @Transactional(readOnly = true)
    Paperback findByTitle(String title);

    @Transactional(readOnly = true)
    @Query("SELECT e FROM Paperback e JOIN FETCH e.author")
    Paperback fetchByAuthorId(Long id);
}