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
@NamedEntityGraph(
        name = "author-books-publisher-graph",
        attributeNodes = {
                @NamedAttributeNode(value = "books",subgraph = "publisher-subgraph")
        },
        subgraphs = {
                @NamedSubgraph(
                        name="publisher-subgraph",
                        attributeNodes = {
                                @NamedAttributeNode("publisher")
                        }
                )
        }
)
public class Author implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String genre;

    private int age;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "author",orphanRemoval = true)
    @JsonManagedReference
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book){
        this.books.add(book);
        book.setAuthor(this);
    }

    public void removeBook(Book book){
        book.setAuthor(null);
        this.books.remove(book);
    }

    public void removeBooks(){
        Iterator<Book> iterator = this.books.iterator();
        while(iterator.hasNext()){
            Book book = iterator.next();
            book.setAuthor(null);
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
