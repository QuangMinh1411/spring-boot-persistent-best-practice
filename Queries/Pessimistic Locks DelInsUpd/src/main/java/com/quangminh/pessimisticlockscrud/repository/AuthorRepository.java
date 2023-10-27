package com.quangminh.pessimisticlockscrud.repository;

import com.quangminh.pessimisticlockscrud.entity.Author;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    @Override
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    public Optional<Author> findById(Long id);

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    public List<Author> findByAgeBetween(int start, int end);

    @Modifying
    @Query("UPDATE Author SET genre = ?1 WHERE id = ?2")
    public void updateGenre(String genre, long id);
}