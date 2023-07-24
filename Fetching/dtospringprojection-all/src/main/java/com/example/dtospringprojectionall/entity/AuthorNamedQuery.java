package com.example.dtospringprojectionall.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NamedQuery(
        name="AuthorNamedQuery.fetchName",
        query="SELECT a.name FROM AuthorNamedQuery a"
)
@NamedQuery(
        name = "AuthorNamedQuery.fetchNameAndAge",
        query = "select a.age AS age,a.name AS name from AuthorNamedQuery a"
)

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AuthorNamedQuery implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int age;
    private String name;
    private String genre;

}
