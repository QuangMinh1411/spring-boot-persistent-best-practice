package vn.com.quangminh.manytooneundirectional.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.com.quangminh.manytooneundirectional.entity.Author;

public interface AuthorRepository extends JpaRepository<Author,Long> {
}
