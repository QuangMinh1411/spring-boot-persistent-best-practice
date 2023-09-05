package com.quangminh.lombokequalshashcode;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "business_key_book")
public class BusinessKeyBook implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String isbn;
    private String title;
    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if(obj == null) {
            return false;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }

        BusinessKeyBook other = (BusinessKeyBook) obj;
        return Objects.equals(isbn, other.getIsbn());
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn);
    }
}