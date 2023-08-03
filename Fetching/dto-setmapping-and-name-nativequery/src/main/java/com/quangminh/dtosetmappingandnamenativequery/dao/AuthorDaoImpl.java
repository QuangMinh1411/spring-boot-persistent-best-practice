package com.quangminh.dtosetmappingandnamenativequery.dao;

import com.quangminh.dtosetmappingandnamenativequery.dto.AuthorDto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
@Transactional(readOnly = true)
public class AuthorDaoImpl implements AuthorDao {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<AuthorDto> fetchNameAndAge() {
        Query query = entityManager.createNativeQuery("SELECT name,age FROM author","AuthorDtoMapping");
        List<AuthorDto> authors = query.getResultList();
        return authors;
    }
}
