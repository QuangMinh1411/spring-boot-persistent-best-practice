package com.quangminh.lombokequalshashcode;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "id_book")
public class IdBook implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String title;
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

        final IdBook other = (IdBook) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.id);

        return hash;
    }
}