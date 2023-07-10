package com.example.cloneentity.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@Entity

@Data
public class Author implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String genre;

    private int age;

    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinTable(name="author_book",
    joinColumns = @JoinColumn(name = "author_id"),
    inverseJoinColumns = @JoinColumn(name = "book_id"))
    @JsonManagedReference
    private Set<Book> books = new HashSet<>();

    private Author(){}
    public Author(Author author, boolean cloneChildren){
        this.genre = author.getGenre();
        if(!cloneChildren){
            books.addAll(author.getBooks());
        }else{
            for(Book book:author.getBooks()){
                addBook(book);
            }
        }
    }

    public void addBook(Book book){
        this.books.add(book);
        book.getAuthors().add(this);
    }
    public void removeBook(Book book){
        this.books.remove(book);
        book.getAuthors().remove(this);
    }

    public void removeBooks(){
        Iterator<Book> iterator = this.books.iterator();
        while (iterator.hasNext()){
            Book book = iterator.next();
            book.getAuthors().remove(this);
            iterator.remove();
        }
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", genre='" + genre + '\'' +
                ", age=" + age +
                '}';
    }
}
