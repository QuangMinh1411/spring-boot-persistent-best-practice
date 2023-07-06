package vn.com.quangminh.manytooneundirectional.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import vn.com.quangminh.manytooneundirectional.entity.Author;
import vn.com.quangminh.manytooneundirectional.entity.Book;
import vn.com.quangminh.manytooneundirectional.repository.AuthorRepository;
import vn.com.quangminh.manytooneundirectional.repository.BookRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookstoreService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    @Transactional
    public void insertNewBook(Long id, Book book){
        Author author = authorRepository.findById(id).orElse(null);
        if(author!=null){
            book.setAuthor(author);
            bookRepository.save(book);
        }
    }

    public List<Book> fetchBooksOfAuthorById(Long id){
        return bookRepository.fetchBoosOfAuthorityById(id);
    }

    public List<Book> fetchPageBooksOfAuthority(Long id,int offset,int size){
        Page<Book> books = bookRepository.fetchPageBooksOfAuthorById(id, PageRequest.of(offset,size, Sort.by(Sort.Direction.ASC,"title")));
        return books.getContent().stream().map(book -> book).collect(Collectors.toList());
    }

    @Transactional
    public List<Book> fetchBooksOfAuthorityByIdAndAddNewBook(Long id, Book book){
        List<Book> books = bookRepository.fetchBoosOfAuthorityById(id);
        book.setAuthor(books.get(0).getAuthor());
        books.add(bookRepository.save(book));
        return books;
    }

    @Transactional
    public List<Book> fetchBooksOfAuthorByIdAndDeleteFirstBook(Long id){
        List<Book> books = bookRepository.fetchBoosOfAuthorityById(id);
        bookRepository.delete(books.remove(0));
        return books;
    }
}
