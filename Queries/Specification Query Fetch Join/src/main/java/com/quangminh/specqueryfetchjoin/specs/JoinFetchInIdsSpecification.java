package com.quangminh.specqueryfetchjoin.specs;

import com.quangminh.specqueryfetchjoin.entity.Author;
import jakarta.persistence.criteria.*;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public class JoinFetchInIdsSpecification implements Specification<Author> {
    private final List<Long> ids;

    public JoinFetchInIdsSpecification(List<Long> ids) {
        this.ids = ids;
    }

    @Override
    public Predicate toPredicate(Root<Author> root, CriteriaQuery<?> cquery, CriteriaBuilder cbuilder) {

        root.fetch("books", JoinType.LEFT);
        cquery.distinct(true);

        // in case you need to add order by via Specification
        //cquery.orderBy(cbuilder.asc(root.get("...")));

        Expression<String> expression = root.get("id");
        return expression.in(ids);
    }
}
