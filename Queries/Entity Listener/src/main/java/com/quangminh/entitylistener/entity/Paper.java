package com.quangminh.entitylistener.entity;

import com.quangminh.entitylistener.entity.Book;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "paper")
public class Paper extends Book implements Serializable {
    private static final long serialVersionUID = 1L;
    private String sizeIn;
    private String weightLbs;
}