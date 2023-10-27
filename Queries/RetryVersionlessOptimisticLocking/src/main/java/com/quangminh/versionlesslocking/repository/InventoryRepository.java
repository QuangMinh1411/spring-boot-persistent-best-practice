package com.quangminh.versionlesslocking.repository;

import com.quangminh.versionlesslocking.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
}