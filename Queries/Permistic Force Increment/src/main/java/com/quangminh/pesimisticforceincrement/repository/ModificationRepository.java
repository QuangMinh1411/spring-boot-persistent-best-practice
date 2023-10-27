package com.quangminh.pesimisticforceincrement.repository;

import com.quangminh.pesimisticforceincrement.entity.Modification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModificationRepository extends JpaRepository<Modification, Long> {
}