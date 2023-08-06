package com.minhquang.joinpagination.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "book")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String title;
    private String isbn;
    private int price;

    @ManyToOne
    @JoinColumn(name = "author_id")
    @JsonBackReference
    private Author author;

}