package com.quangminh.resulttransformer.dao;

import com.quangminh.resulttransformer.dto.AuthorDtoNoSetters;
import com.quangminh.resulttransformer.dto.AuthorDtoWithSetter;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.hibernate.transform.AliasToBeanConstructorResultTransformer;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class Dao implements AuthorDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional(readOnly = true)
    public List<AuthorDtoNoSetters> fetchAuthorsNoSetters() {
        Query query = entityManager
                .createNativeQuery("SELECT name, age FROM author")
                .unwrap(org.hibernate.query.NativeQuery.class)
                .setResultTransformer(
                        new AliasToBeanConstructorResultTransformer(
                                AuthorDtoNoSetters.class.getConstructors()[0]
                        )
                );

        List<AuthorDtoNoSetters> authors = query.getResultList();

        return authors;
    }

    @Override
    @Transactional(readOnly = true)
    public List<AuthorDtoWithSetter> fetchAuthorsWithSetters() {
        Query query = entityManager
                .createNativeQuery("SELECT name, age FROM author")
                .unwrap(org.hibernate.query.NativeQuery.class)
                .setResultTransformer(
                        Transformers.aliasToBean(AuthorDtoWithSetter.class)
                );

        List<AuthorDtoWithSetter> authors = query.getResultList();

        return authors;
    }

    protected EntityManager getEntityManager() {
        return entityManager;
    }
}
