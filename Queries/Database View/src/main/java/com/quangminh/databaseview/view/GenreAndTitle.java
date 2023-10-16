package com.quangminh.databaseview.view;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import org.springframework.data.annotation.Immutable;

import java.io.Serializable;

@Getter
@Entity
@Immutable
@Table(name = "genre_and_title")

public class GenreAndTitle implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private String title;
    private String genre;
}