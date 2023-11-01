package com.quangminh.joinstrategy.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Entity
@PrimaryKeyJoinColumn(name="paperback_book_id")
public class Paperback extends Book implements Serializable {

    private static final long serialVersionUID = 1L;
    private String sizeIn;
    private String weightLbs;
    @Override
    public String toString() {
        return super.toString() + ", Paperback{" + "sizeIn=" + sizeIn + ", weightLbs=" + weightLbs + '}';
    }
}