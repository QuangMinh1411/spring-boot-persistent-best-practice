package com.quangminh.elementcollectionjoinfetch.dto;

/**
 * Projection for {@link com.quangminh.elementcollectionjoinfetch.entity.ShoppingCart}
 */
public interface ShoppingCartDto {
    String getOwner();

    String getTitle();
    int getPrice();
}