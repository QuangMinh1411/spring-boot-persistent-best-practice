package vn.com.quangminh.manytomanybidirectional.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
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
    @JoinTable(name = "author_book",
    joinColumns = @JoinColumn(name = "author_id"),
    inverseJoinColumns = @JoinColumn(name = "book_id"))
    @JsonIgnore
    private Set<Book> books = new HashSet<>();

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return id!=null && id.equals(((Author)o).id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, genre, age);
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
