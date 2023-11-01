package com.quangminh.tableclassinheritance.repository;

import com.quangminh.tableclassinheritance.entity.Ebook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface EbookRepository extends JpaRepository<Ebook, Long> {
    @Transactional(readOnly = true)
    Ebook findByTitle(String title);
}