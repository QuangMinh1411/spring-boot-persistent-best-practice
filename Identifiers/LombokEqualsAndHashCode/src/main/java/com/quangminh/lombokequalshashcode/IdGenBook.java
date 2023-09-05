package com.quangminh.lombokequalshashcode;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "id_gen_book")
public class IdGenBook implements Serializable {
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

        IdGenBook other = (IdGenBook) obj;
        return id != null && id.equals(other.getId());
    }

    @Override
    public int hashCode() {
        return 2021;
    }
}