package com.quangminh.namessubgraph.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Publisher implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String company;
    @OneToMany(cascade = CascadeType.ALL,
    mappedBy = "publisher",orphanRemoval = true)
    @JsonManagedReference
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book){
        this.books.add(book);
        book.setPublisher(this);
    }

    public void removeBook(Book book){
        book.setPublisher(null);
        this.books.remove(book);
    }

    public void removeBooks(){
        Iterator<Book> iterator = this.books.iterator();
        while(iterator.hasNext()){
            Book book = iterator.next();
            book.setPublisher(null);
            iterator.remove();
        }
    }
}
