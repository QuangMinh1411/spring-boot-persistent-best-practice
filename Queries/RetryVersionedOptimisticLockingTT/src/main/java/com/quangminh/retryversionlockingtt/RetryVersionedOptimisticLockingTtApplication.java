package com.quangminh.retryversionlockingtt;

import com.quangminh.retryversionlockingtt.service.InventoryService;
import com.vladmihalcea.concurrent.aop.OptimisticConcurrencyControlAspect;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
@EnableAspectJAutoProxy
public class RetryVersionedOptimisticLockingTtApplication {


    private final InventoryService inventoryService;

    public RetryVersionedOptimisticLockingTtApplication(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    public static void main(String[] args) {
        SpringApplication.run(RetryVersionedOptimisticLockingTtApplication.class, args);
    }
    @Bean
    public OptimisticConcurrencyControlAspect
    optimisticConcurrencyControlAspect() {

        return new OptimisticConcurrencyControlAspect();
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
