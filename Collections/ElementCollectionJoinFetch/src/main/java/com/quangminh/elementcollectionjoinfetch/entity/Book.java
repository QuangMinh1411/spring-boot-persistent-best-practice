package com.quangminh.elementcollectionjoinfetch.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Embeddable
public class Book implements Serializable {
    private static final long serialVersionUID = 1L;

    private String title;
    private String isbn;
    private String genre;
    private int price;

}