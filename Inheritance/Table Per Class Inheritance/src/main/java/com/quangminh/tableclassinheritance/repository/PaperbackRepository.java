package com.quangminh.tableclassinheritance.repository;

import com.quangminh.tableclassinheritance.entity.Paperback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface PaperbackRepository extends JpaRepository<Paperback, Long> {
    @Transactional(readOnly = true)
    Paperback findByTitle(String title);
}