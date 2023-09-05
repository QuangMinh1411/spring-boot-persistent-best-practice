package com.quangminh.lombokequalshashcode;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "id_man_book")
public class IdManBook implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
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

        IdManBook other = (IdManBook) obj;
        return Objects.equals(id, other.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}