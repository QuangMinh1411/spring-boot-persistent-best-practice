package com.quangminh.retryversionlockingtt.repository;

import com.quangminh.retryversionlockingtt.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
}