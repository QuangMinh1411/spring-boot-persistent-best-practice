package com.quangminh.jpainheritancejoined.repository;

import com.quangminh.jpainheritancejoined.entity.Paperback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface PaperbackRepository extends JpaRepository<Paperback, Long> {
    @Transactional(readOnly = true)
    Paperback findByTitle(String title);
}