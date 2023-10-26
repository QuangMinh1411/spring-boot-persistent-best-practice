package com.quangminh.retryversionlockingtt.service;

import com.quangminh.retryversionlockingtt.entity.Inventory;
import com.quangminh.retryversionlockingtt.repository.InventoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

@Service
public class InventoryService implements Runnable{

    private final InventoryRepository inventoryRepository;
    private final TransactionTemplate transactionTemplate;
    public InventoryService(InventoryRepository inventoryRepository, TransactionTemplate transactionTemplate) {
        this.inventoryRepository = inventoryRepository;
        this.transactionTemplate = transactionTemplate;
    }


    @Override
    public void run() {
        transactionTemplate.execute(
                new TransactionCallbackWithoutResult() {
                    @Override
                    public void doInTransactionWithoutResult(TransactionStatus status) {
                        Inventory inventory = inventoryRepository.findById(1L).orElseThrow();
                        inventory.setQuantity(inventory.getQuantity() - 2);
                    }
                });
    }
}
