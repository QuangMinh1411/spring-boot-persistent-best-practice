package com.quangminh.elementcollectionjoinfetch.controller;

import com.quangminh.elementcollectionjoinfetch.service.ShoppingCartService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shopping_cart")
public class BookstoreController {

    private final ShoppingCartService shoppingCartService;

    public BookstoreController(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }
    @GetMapping
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(shoppingCartService.allShoppingCart(), HttpStatus.OK);
    }

    @GetMapping("/{price}")
    public ResponseEntity<?> byPrice(@PathVariable int price){
        return new ResponseEntity<>(shoppingCartService.byPriceShoppingCart(price),HttpStatus.OK);
    }

}
