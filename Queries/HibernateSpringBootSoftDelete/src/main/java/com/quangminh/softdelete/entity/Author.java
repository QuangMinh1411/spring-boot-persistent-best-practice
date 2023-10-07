package com.quangminh.softdelete.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.quangminh.softdelete.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Getter
@Setter
@Entity
@SQLDelete(sql = "UPDATE author SET deleted=true WHERE id=?")
@Table(name = "author")
@Where(clause = "deleted=false")
public class Author extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private String genre;
    private int age;

    @OneToMany(mappedBy = "author", orphanRemoval = true)
    @JsonManagedReference
    private List<Book> books = new ArrayList<>();
    public void addBook(Book book) {
        this.books.add(book);
        book.setAuthor(this);
    }

    public void removeBook(Book book) {
        book.setAuthor(null);
        this.books.remove(book);
    }

    public void removeBooks() {
        Iterator<Book> iterator = this.books.iterator();

        while (iterator.hasNext()) {
            Book book = iterator.next();

            book.setAuthor(null);
            iterator.remove();
        }
    }

}