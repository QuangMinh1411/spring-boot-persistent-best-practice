package com.quangminh.versionoptimisticdetachentity.service;

import com.quangminh.versionoptimisticdetachentity.entity.Inventory;
import com.quangminh.versionoptimisticdetachentity.repository.InventoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }
    public Inventory firstTransactionFetchesAndReturn() {
        Inventory firstInventory = inventoryRepository.findById(1L).orElseThrow();

        return firstInventory;
    }
    @Transactional
    public void secondTransactionFetchesAndReturn() {
        Inventory secondInventory = inventoryRepository.findById(1L).orElseThrow();

        secondInventory.setQuantity(secondInventory.getQuantity() - 1);
    }

    public void thirdTransactionMergesAndUpdates(Inventory firstInventory) {
        inventoryRepository.save(firstInventory); // calls EntityManager#merge() behind the scene

        // this ends up in optimistic locking exception
    }
}
