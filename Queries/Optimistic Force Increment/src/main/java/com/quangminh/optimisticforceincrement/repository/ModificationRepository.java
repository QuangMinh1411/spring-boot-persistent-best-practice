package com.quangminh.optimisticforceincrement.repository;

import com.quangminh.optimisticforceincrement.entity.Modification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModificationRepository extends JpaRepository<Modification, Long> {
}