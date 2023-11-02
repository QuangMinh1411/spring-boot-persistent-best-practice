package com.quangminh.enumpostgres.entity;

import com.quangminh.enumpostgres.enums.GenreType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcType;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

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

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "genre_info")
    private GenreType genre;

}