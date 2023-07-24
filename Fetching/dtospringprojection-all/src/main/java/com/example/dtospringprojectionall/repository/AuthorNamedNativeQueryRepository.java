package com.example.dtospringprojectionall.repository;

import com.example.dtospringprojectionall.dto.AuthorNamedNativeQueryNameAge;
import com.example.dtospringprojectionall.entity.AuthorNamedNativeQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional(readOnly = true)
public interface AuthorNamedNativeQueryRepository extends JpaRepository<AuthorNamedNativeQuery,Long> {
    List<String> fetchName();
    List<AuthorNamedNativeQueryNameAge> fetchNameAndAge();
}
