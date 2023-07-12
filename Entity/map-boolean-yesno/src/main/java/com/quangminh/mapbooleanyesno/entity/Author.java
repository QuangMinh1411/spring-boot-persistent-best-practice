package com.quangminh.mapbooleanyesno.entity;

import com.quangminh.mapbooleanyesno.converter.BooleanConverter;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Author implements Serializable {
    private static final long serialVersionID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int age;
    private String name;
    private String genre;
    @Convert(converter = BooleanConverter.class)
    @NotNull
    public Boolean bestSelling;

}
