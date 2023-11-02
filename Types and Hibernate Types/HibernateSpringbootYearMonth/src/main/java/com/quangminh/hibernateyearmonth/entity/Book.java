package com.quangminh.hibernateyearmonth.entity;

import com.vladmihalcea.hibernate.type.basic.YearMonthIntegerType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.YearMonth;
import org.hibernate.annotations.TypeDef;

@Getter
@Setter
@Entity
@Table(name = "book")


@TypeDef(
        typeClass = YearMonthIntegerType.class, // or, YearMonthDateType
        defaultForType = YearMonth.class
)
public class Book implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String title;
    private String isbn;
    private YearMonth releaseDate;
}