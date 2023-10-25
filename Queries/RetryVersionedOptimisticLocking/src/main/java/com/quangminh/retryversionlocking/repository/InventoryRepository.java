package com.quangminh.retryversionlocking.repository;

import com.quangminh.retryversionlocking.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
}