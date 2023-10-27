package com.quangminh.httpdetachedentity.repository;

import com.quangminh.httpdetachedentity.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
}