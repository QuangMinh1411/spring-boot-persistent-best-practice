package com.quangminh.collectionwithordercolumn.repository;

import com.quangminh.collectionwithordercolumn.entity.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {
    @Transactional(readOnly=true)
    ShoppingCart findByOwner(String owner);
}