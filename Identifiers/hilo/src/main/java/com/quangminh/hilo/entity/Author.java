package com.quangminh.hilo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "author")
public class Author implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hilo")
    @GenericGenerator(name = "hilo", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "hilo_sequence"),
                    @Parameter(name = "initial_value", value = "1"),
                    @Parameter(name = "increment_size", value = "100"),
                    @Parameter(name = "optimizer", value = "hilo")
            }
    )
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
}