package com.quangminh.optimisticlocking;

import com.quangminh.optimisticlocking.service.InventoryService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class SimulatedVersionedOptimisticLockingApplication {


    private final InventoryService inventoryService;

    public SimulatedVersionedOptimisticLockingApplication(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    public static void main(String[] args) {
        SpringApplication.run(SimulatedVersionedOptimisticLockingApplication.class, args);
    }

    @Bean
    public ApplicationRunner init() {
        return args -> {

            ExecutorService executor = Executors.newFixedThreadPool(2);
            executor.execute(inventoryService);
            // Thread.sleep(2000); -> adding a sleep here will break the transactions concurrency
            executor.execute(inventoryService);

            executor.shutdown();
            try {
                executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        };
    }
}
