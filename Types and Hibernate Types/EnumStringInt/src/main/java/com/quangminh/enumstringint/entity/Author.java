package com.quangminh.enumstringint.entity;

import com.quangminh.enumstringint.enums.GenreType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

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
    private int age;
    private String name;

    // @Enumerated(EnumType.STRING)
    // @Column(length = 9)
    @Enumerated(EnumType.ORDINAL)
    @Column(columnDefinition = "TINYINT")
    private GenreType genre;
    @Override
    public String toString() {
        return "Author{" + "id=" + id + ", age=" + age
                + ", name=" + name + ", genre=" + genre + '}';
    }
}