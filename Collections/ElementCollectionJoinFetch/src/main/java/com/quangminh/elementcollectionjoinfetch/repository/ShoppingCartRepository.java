package com.quangminh.elementcollectionjoinfetch.repository;

import com.quangminh.elementcollectionjoinfetch.dto.ShoppingCartDto;
import com.quangminh.elementcollectionjoinfetch.entity.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {
    @Query("select p from ShoppingCart p join fetch p.books")
    List<ShoppingCart> fetchShoppingCart();
    @Query("select p from ShoppingCart p join fetch p.books b where b.price>?1")
    List<ShoppingCart> fetchShoppingCartByPrice(int price);

    @Query("select a.owner as owner,b.title as title,b.price as price from ShoppingCart a join a.books b")
    List<ShoppingCartDto> getShoppingCartDto();
    @Query("select a.owner as owner,b.title as title,b.price as price from ShoppingCart a join a.books b where b.price>?1")
    List<ShoppingCartDto> getShoppingCartDtoViaPrice(int price);
}