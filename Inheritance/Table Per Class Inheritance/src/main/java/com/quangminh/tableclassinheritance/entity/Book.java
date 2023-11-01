package com.quangminh.tableclassinheritance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "book")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Book implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    private String title;
    private String isbn;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private Author author;

    @Override
    public String toString() {
        return "Book{" + "id=" + id + ", title=" + title + ", isbn=" + isbn + '}';
    }
}