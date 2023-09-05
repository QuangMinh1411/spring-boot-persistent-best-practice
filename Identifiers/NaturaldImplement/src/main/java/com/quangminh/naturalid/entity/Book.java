package com.quangminh.naturalid.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;

import java.io.Serializable;
import java.util.Objects;

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
    private int price;

    @NaturalId
    @Column(nullable = false, updatable = false, unique = true, length = 50)
    private String isbn;

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }

        if (getClass() != o.getClass()) {
            return false;
        }

        Book other = (Book) o;
        return Objects.equals(isbn, other.getIsbn());
        // including sku
        // return Objects.equals(isbn, other.getIsbn())
        //        && Objects.equals(sku, other.getSku());
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn);
        // including sku
        // return Objects.hash(isbn, sku);
    }

    @Override
    public String toString() {
        return "Book{" + "id=" + id + ", title=" + title + ", isbn=" + isbn + ", price=" + price + '}';
        // including sku
        //return "Book{" + "id=" + id + ", title=" + title
        //         + ", isbn=" + isbn + ", price=" + price + ", sku=" + sku + '}';
    }
}