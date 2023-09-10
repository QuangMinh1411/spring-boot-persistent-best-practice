package com.quangminh.propertyformula.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Formula;

import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "book")
public class Book implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String title;
    private String isbn;
    private double price;

    @Formula("price - price * 0.25")
    private double discounted;
}