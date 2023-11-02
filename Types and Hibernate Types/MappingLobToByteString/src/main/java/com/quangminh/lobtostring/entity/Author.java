package com.quangminh.lobtostring.entity;

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
    private String genre;

    @Lob
    @Column(name = "avatar",columnDefinition = "BLOB")
    private byte[] avatar;

    @Lob
    @Column(name = "biography",columnDefinition = "BLOB")
    private String biography;

    @Override
    public String toString() {
        return "Author{" + "id=" + id + ", age=" + age
                + ", name=" + name + ", genre=" + genre + '}';
    }
}