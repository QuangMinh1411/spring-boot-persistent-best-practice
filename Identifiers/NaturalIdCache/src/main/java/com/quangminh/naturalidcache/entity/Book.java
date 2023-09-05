package com.quangminh.naturalidcache.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.NaturalIdCache;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "book")
@NaturalIdCache
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE,region = "Book")
public class Book implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String title;
    private int price;
    @NaturalId(mutable = false)
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
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn);
    }

    @Override
    public String toString() {
        return "Book{" + "id=" + id + ", title=" + title
                + ", isbn=" + isbn + ", price=" + price + '}';
    }
}