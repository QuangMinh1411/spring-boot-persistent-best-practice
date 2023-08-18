package com.quangminh.elementcollectionjoinfetch.service;

import com.quangminh.elementcollectionjoinfetch.dto.ShoppingCartDto;
import com.quangminh.elementcollectionjoinfetch.entity.ShoppingCart;
import com.quangminh.elementcollectionjoinfetch.repository.ShoppingCartRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ShoppingCartService {

    private final ShoppingCartRepository shoppingCartRepository;

    public ShoppingCartService(ShoppingCartRepository shoppingCartRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
    }
    @Transactional(readOnly = true)
    public List<ShoppingCart> allShoppingCart(){
        return shoppingCartRepository.fetchShoppingCart();
    }
    @Transactional(readOnly = true)
    public List<ShoppingCart> byPriceShoppingCart(int price){
        return shoppingCartRepository.fetchShoppingCartByPrice(price);
    }

    @Transactional(readOnly = true)
    public List<ShoppingCartDto> getDto(){
        return shoppingCartRepository.getShoppingCartDto();
    }
    @Transactional(readOnly = true)
    public List<ShoppingCartDto> byPriceDto(int price){
        return shoppingCartRepository.getShoppingCartDtoViaPrice(price);
    }
}
