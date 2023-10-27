package com.quangminh.versionoptimisticdetachentity.repository;

import com.quangminh.versionoptimisticdetachentity.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
}