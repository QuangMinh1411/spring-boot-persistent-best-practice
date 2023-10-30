package com.quangminh.specificsubclassinheritance.repository;

import com.quangminh.specificsubclassinheritance.entity.Ebook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface EbookRepository extends JpaRepository<Ebook, Long> {
    @Transactional(readOnly = true)
    @Query("SELECT b FROM Author a JOIN a.books b WHERE a.name = ?1 AND TYPE(b) = 'Ebook'")
    public List<Ebook> findByAuthorName(String name);
}