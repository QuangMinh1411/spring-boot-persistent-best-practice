package com.quangminh.optimisticlocking.service;

import com.quangminh.optimisticlocking.entity.Inventory;
import com.quangminh.optimisticlocking.repository.InventoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InventoryService implements Runnable{

    private final InventoryRepository inventoryRepository;

    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    @Override
    @Transactional
    public void run() {
        Inventory inventory = inventoryRepository.findById(1L).orElseThrow();
        inventory.setQuantity(inventory.getQuantity() - 2);
    }
}
