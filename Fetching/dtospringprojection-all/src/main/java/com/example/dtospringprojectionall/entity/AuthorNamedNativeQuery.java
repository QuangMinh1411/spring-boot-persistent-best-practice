package com.example.dtospringprojectionall.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NamedNativeQuery(
        name="AuthorNamedNativeQuery.fetchName",
        query="SELECT name FROM author_named_native_query"
)
@NamedNativeQuery(
        name = "AuthorNamedNativeQuery.fetchNameAndAge",
        query = "select age,name from author_named_native_query"
)
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AuthorNamedNativeQuery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int age;
    private String name;
    private String genre;
}
