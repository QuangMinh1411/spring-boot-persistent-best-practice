package com.quangminh.noordercolumn.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "shopping_cart")
public class ShoppingCart implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String owner;

    @ElementCollection
    @CollectionTable(
            name = "shopping_cart_books",
            joinColumns = @JoinColumn(name = "shopping_cart_id")
    )
    @Column(name = "title")
    private List<String> books = new ArrayList<>();

}