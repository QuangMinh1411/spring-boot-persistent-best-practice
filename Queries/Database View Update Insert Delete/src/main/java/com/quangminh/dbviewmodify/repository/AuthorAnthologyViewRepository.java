package com.quangminh.dbviewmodify.repository;

import com.quangminh.dbviewmodify.view.AuthorAnthologyView;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorAnthologyViewRepository extends JpaRepository<AuthorAnthologyView, Long> {
    AuthorAnthologyView findByName(String name);
}