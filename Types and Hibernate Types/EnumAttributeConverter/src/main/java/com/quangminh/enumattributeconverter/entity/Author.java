package com.quangminh.enumattributeconverter.entity;

import com.quangminh.enumattributeconverter.converter.GenreTypeConverter;
import com.quangminh.enumattributeconverter.enums.GenreType;
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

    @Convert(converter = GenreTypeConverter.class)
    @Column(columnDefinition = "TINYINT")
    private GenreType genre;
}