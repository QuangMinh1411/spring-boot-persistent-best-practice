package com.quangminh.collectionwithordercolumn;

import com.quangminh.collectionwithordercolumn.service.ShoppingCartService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CollectionWithOrderColumnApplication {


    private final ShoppingCartService shoppingCartService;

    public CollectionWithOrderColumnApplication(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    public static void main(String[] args) {
        SpringApplication.run(CollectionWithOrderColumnApplication.class, args);
    }

    @Bean
    public ApplicationRunner init() {
        return args -> {

            System.out.println("\nAdd one book at the beginning of the current cart ...");
            shoppingCartService.addToTheBeginning();

            System.out.println("\nAdd one book at the end of the current cart ...");
            shoppingCartService.addToTheEnd();

            System.out.println("\nAdd one book in the middle of the current cart ...");
            shoppingCartService.addInTheMiddle();

            System.out.println("\nRemove first book from the cart ...");
            shoppingCartService.removeFirst();

            System.out.println("\nRemove last book from the cart ...");
            shoppingCartService.removeLast();

            System.out.println("\nRemove middle book from the cart ...");
            shoppingCartService.removeMiddle();

        };
    }
}
