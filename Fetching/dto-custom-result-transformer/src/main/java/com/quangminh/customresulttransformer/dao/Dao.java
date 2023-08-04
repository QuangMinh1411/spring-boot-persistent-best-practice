package com.quangminh.customresulttransformer.dao;

import com.quangminh.customresulttransformer.dto.AuthorDto;
import com.quangminh.customresulttransformer.transformer.AuthorBookTransformer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
public class Dao implements AuthorDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional(readOnly = true)
    public List<AuthorDto> fetchAuthorWithBook() {
        Query query = entityManager.createQuery("SELECT a.id as author_id,a.name as name,a.age as age,b.id as book_id,b.title as title " +
                        "from Author a join Book b ON a.id=b.author.id")
                .unwrap(org.hibernate.query.Query.class).setResultTransformer(new AuthorBookTransformer());
        List<AuthorDto> authors = query.getResultList();
        return authors;

    }
}
