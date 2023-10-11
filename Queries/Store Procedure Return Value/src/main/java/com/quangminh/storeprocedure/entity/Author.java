package com.quangminh.storeprocedure.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "author")
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(
                name = "CountByGenreProcedure",
                procedureName = "COUNT_AUTHOR_BY_GENRE",
                resultClasses = {Author.class},
                parameters = {
                        @StoredProcedureParameter(
                                name = "p_genre",
                                type = String.class,
                                mode = ParameterMode.IN),
                        @StoredProcedureParameter(
                                name = "p_count",
                                type = Integer.class,
                                mode = ParameterMode.OUT)})
})
public class Author implements Serializable {
    public static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private int age;
    private String name;
    private String genre;
}