package com.quangminh.propertypostload.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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
    @Transient
    private double discounted;
    @PostLoad
    private void postLoad(){
        this.discounted = this.price-this.price*0.25;
    }
    @Override
    public String toString() {
        return "Book{" + "id=" + id + ", title=" + title + ", isbn="
                + isbn + ", price=" + price + ", discounted=" + discounted + '}';
    }
}
