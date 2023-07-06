package vn.com.quangminh.manytomanybidirectional.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.com.quangminh.manytomanybidirectional.entity.Author;

public interface AuthorRepository extends JpaRepository<Author,Long> {
}
