package com.quangminh.singletableinheritance.repository;

import com.quangminh.singletableinheritance.entity.Ebook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface EbookRepository extends JpaRepository<Ebook, Long> {
    @Transactional(readOnly = true)
    Ebook findByTitle(String title);
}