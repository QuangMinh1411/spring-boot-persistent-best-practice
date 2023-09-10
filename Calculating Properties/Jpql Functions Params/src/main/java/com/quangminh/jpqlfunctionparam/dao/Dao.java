package com.quangminh.jpqlfunctionparam.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.time.Instant;
@Repository
public class Dao<T, ID extends Serializable> implements GenericDao<T, ID> {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional(readOnly = true)
    public String fetchTitleAndPrice(String symbol, Instant instant) {

        return (String) entityManager.createQuery(
                        "SELECT concat_ws(b.title, :symbol, b.price, :instant) FROM Book b WHERE b.id = 1"
                )
                .setParameter("symbol", symbol)
                .setParameter("instant", instant)
                .getSingleResult();
    }
}
