package com.quangminh.lombokequalshashcode;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "natural_id_book")
public class NaturalIdBook implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String title;

    @NaturalId
    @Column(nullable = false, updatable = false, unique = true, length = 50)
    private String isbn;

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

        NaturalIdBook other = (NaturalIdBook) obj;
        return Objects.equals(isbn, other.getIsbn());
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn);
    }
}