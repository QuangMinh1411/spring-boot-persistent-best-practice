package com.example.domainevent.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Book implements Serializable {
    private static final long serialVersionUID =1L;

    @Id
    private Long id;

    private String title;

    private String author;

    @OneToMany(cascade = CascadeType.ALL,
    mappedBy = "book",orphanRemoval = true)
    private List<BookReview> reviews = new ArrayList<>();

    public void addReview(BookReview review){
        this.reviews.add(review);
        review.setBook(this);
    }
    public void removeReview(BookReview review){
        review.setBook(null);
        reviews.remove(review);
    }
}
