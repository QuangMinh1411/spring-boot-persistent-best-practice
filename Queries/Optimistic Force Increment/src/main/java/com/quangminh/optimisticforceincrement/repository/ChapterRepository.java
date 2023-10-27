package com.quangminh.optimisticforceincrement.repository;

import com.quangminh.optimisticforceincrement.entity.Chapter;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

import java.util.Optional;

public interface ChapterRepository extends JpaRepository<Chapter, Long> {
    @Override
    @Lock(LockModeType.OPTIMISTIC_FORCE_INCREMENT)
    public Optional<Chapter> findById(Long id);
}