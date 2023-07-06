package vn.com.quangminh.manytomanybidirectional.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vn.com.quangminh.manytomanybidirectional.entity.Author;
import vn.com.quangminh.manytomanybidirectional.entity.Book;
import vn.com.quangminh.manytomanybidirectional.repository.AuthorRepository;

@Service
@RequiredArgsConstructor
public class BookstoreService {
    private final AuthorRepository authorRepository;
    @Transactional
    public void insertAuthorsWithBooks(Long id, Book book){
        Author author = authorRepository.findById(id).orElse(null);
        if(author!=null){
            author.addBook(book);
            authorRepository.save(author);
        }

    }

    public Author createAuthor(Author author){
        return authorRepository.save(author);
    }
}
