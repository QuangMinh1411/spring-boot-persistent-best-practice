package com.example.dtospringprojectionall.repository;

import com.example.dtospringprojectionall.dto.AuthorNamedQueryNameAge;
import com.example.dtospringprojectionall.entity.AuthorNamedQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
public interface AuthorNamedQueryRepository extends JpaRepository<AuthorNamedQuery,Long> {
    List<String> fetchName();
    List<AuthorNamedQueryNameAge> fetchNameAndAge();
}
