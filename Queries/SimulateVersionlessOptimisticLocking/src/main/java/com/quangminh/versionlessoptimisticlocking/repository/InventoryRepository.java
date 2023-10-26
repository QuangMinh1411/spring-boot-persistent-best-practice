package com.quangminh.versionlessoptimisticlocking.repository;

import com.quangminh.versionlessoptimisticlocking.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
}