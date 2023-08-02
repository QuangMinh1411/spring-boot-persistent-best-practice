package com.quangminh.dtosetmappingandnamenativequery.entity;

import com.quangminh.dtosetmappingandnamenativequery.dto.AuthorDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
@SqlResultSetMapping(
        name = "AuthorsNameMapping",
        columns = {
                @ColumnResult(name = "name")
        }
)
@NamedNativeQuery(
        name = "Author.fetchName",
        query = "SELECT name FROM author",
        resultSetMapping = "AuthorsNameMapping"
)

// Constructor Mapping
@NamedNativeQuery(
        name = "Author.fetchNameAndAge",
        query = "SELECT name, age FROM author",
        resultSetMapping = "AuthorDtoMapping"
)
@SqlResultSetMapping(
        name = "AuthorDtoMapping",
        classes = @ConstructorResult(
                targetClass = AuthorDto.class,
                columns = {
                        @ColumnResult(name = "name"),
                        @ColumnResult(name = "age")
                }
        )
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

    private int age;
    private String name;
    private String genre;

}