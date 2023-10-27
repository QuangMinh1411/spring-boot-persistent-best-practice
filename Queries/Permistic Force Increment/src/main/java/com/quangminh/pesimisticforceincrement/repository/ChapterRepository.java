package com.quangminh.pesimisticforceincrement.repository;

import com.quangminh.pesimisticforceincrement.entity.Chapter;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

import java.util.Optional;

public interface ChapterRepository extends JpaRepository<Chapter, Long> {
    @Override
    @Lock(LockModeType.PESSIMISTIC_FORCE_INCREMENT)
    public Optional<Chapter> findById(Long id);

    public Chapter findByTitle(String title);
}