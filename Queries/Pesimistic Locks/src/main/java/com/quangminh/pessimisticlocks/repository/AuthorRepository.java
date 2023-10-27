package com.quangminh.pessimisticlocks.repository;

import com.quangminh.pessimisticlocks.entity.Author;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    @Override
    @Lock(LockModeType.PESSIMISTIC_READ) // for exclusive lock switch to PESSIMISTIC_WRITE
    public Optional<Author> findById(Long id);
}