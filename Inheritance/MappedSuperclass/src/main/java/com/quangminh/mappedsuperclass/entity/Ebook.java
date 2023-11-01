package com.quangminh.mappedsuperclass.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "ebook")
public class Ebook extends Book implements Serializable {
    private static final long serialVersionUID = 1L;
    private String format;
}