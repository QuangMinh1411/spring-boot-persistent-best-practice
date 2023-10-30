package com.quangminh.specificsubclassinheritance.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Entity
@PrimaryKeyJoinColumn(name = "ebook_book_id")
public class Ebook extends Book implements Serializable {
    private static final long serialVersionUID = 1L;
    private String format;
}