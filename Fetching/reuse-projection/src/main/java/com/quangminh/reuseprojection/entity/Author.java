package com.quangminh.reuseprojection.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@ToString
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "author")
public class Author implements Serializable {
    private static final long serialVersionUID = 1L;
    @ToString.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ToString.Include
    @Column(name = "name")
    private String name;

    @ToString.Include
    @Column(name = "genre")
    private String genre;
    @ToString.Include
    @Column(nullable = false)
    private int age;
    @ToString.Include
    private String email;
    @ToString.Include
    private String address;
    @ToString.Include
    private String rating;


}