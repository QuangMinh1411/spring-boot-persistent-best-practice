package com.quangminh.optimisticlocking.repository;

import com.quangminh.optimisticlocking.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
}