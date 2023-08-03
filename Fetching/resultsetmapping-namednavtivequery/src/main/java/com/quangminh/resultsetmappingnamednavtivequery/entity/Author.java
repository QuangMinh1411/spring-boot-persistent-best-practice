package com.quangminh.resultsetmappingnamednavtivequery.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
@NamedNativeQuery(
        name = "AuthorQuery",
        query = "SELECT * FROM author",
        resultSetMapping = "AuthorMapping"
)
@SqlResultSetMapping(
        name = "AuthorMapping",
        entities = {
                @EntityResult(
                        entityClass = Author.class,
                        fields = {
                                @FieldResult(name = "id", column = "id"),
                                @FieldResult(name = "name", column = "name"),
                                @FieldResult(name = "genre", column = "genre"),
                                @FieldResult(name = "age", column = "age")
                        }
                )
        }
)

// Multiple entities
@NamedNativeQuery(
        name = "AuthorWithBookQuery",
        query = "SELECT a.name,a.age FROM author a INNER JOIN book b ON a.id = b.author_id",
        resultSetMapping = "AuthorWithBookMapping"
)
@SqlResultSetMapping(
        name = "AuthorWithBookMapping",
        entities = {
                @EntityResult(
                        entityClass = Author.class,
                        fields = {

                                @FieldResult(name = "name", column = "name"),

                                @FieldResult(name = "age", column = "age")
                        }
                ),
                @EntityResult(
                        entityClass = Book.class,
                        fields = {
                                @FieldResult(name = "id", column = "id"),
                                @FieldResult(name = "title", column = "title"),
                                @FieldResult(name = "isbn", column = "isbn")
                        }
                )
        }
)
@Getter
@Setter
@Entity
@Table(name = "author")
public class Author implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;


    private String name;


    private String genre;

    private int age;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, orphanRemoval = true)
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