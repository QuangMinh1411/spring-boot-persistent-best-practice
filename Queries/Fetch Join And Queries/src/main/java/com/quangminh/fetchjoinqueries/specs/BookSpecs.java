package com.quangminh.fetchjoinqueries.specs;

import com.quangminh.fetchjoinqueries.entity.Book;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

public class BookSpecs {
    private static final int PRICE = 35;

    public static Specification<Book> isPriceGt35() {
        return (Root<Book> root,
                CriteriaQuery<?> query, CriteriaBuilder builder)
                -> builder.greaterThan(root.get("price"), PRICE);
    }
}
