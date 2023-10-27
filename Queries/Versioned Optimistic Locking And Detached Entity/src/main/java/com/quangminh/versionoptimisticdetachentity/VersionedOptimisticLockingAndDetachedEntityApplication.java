package com.quangminh.versionoptimisticdetachentity;

import com.quangminh.versionoptimisticdetachentity.entity.Inventory;
import com.quangminh.versionoptimisticdetachentity.service.InventoryService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class VersionedOptimisticLockingAndDetachedEntityApplication {

    private final InventoryService inventoryService;

    public VersionedOptimisticLockingAndDetachedEntityApplication(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    public static void main(String[] args) {
        SpringApplication.run(VersionedOptimisticLockingAndDetachedEntityApplication.class, args);
    }
    @Bean
    public ApplicationRunner init() {
        return args -> {

            System.out.println("Triggering the first transaction ...");
            Inventory firstInventory = inventoryService.firstTransactionFetchesAndReturn();
            System.out.println("First transaction committed successfully ...");

            System.out.println("Triggering the second transaction ...");
            inventoryService.secondTransactionFetchesAndReturn();
            System.out.println("Second transaction committed successfully ...");

            // AT THIS POINT, THE firstInventory IS DETACHED
            firstInventory.setQuantity(firstInventory.getQuantity() - 1);

            System.out.println("Triggering the third transaction ...");
            inventoryService.thirdTransactionMergesAndUpdates(firstInventory);
            System.out.println("Third transaction committed successfully ...");
        };
    }
}
