package vn.com.quangminh.manytomanybidirectional.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.com.quangminh.manytomanybidirectional.entity.Book;

public interface BookRepository extends JpaRepository<Book,Long> {
}
