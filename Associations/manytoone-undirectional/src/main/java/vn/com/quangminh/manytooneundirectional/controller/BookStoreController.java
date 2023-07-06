package vn.com.quangminh.manytooneundirectional.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.com.quangminh.manytooneundirectional.entity.Book;
import vn.com.quangminh.manytooneundirectional.service.BookstoreService;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookStoreController {
    private final BookstoreService service;
    @PostMapping("/insert")
    public ResponseEntity<?> insertNewBook(@RequestBody Book book, @RequestParam Long id){
        service.insertNewBook(id,book);
        return new ResponseEntity<>("Insert success", HttpStatus.CREATED);
    }

    @GetMapping("/author/{id}")
    public ResponseEntity<?> getBooksFromAuthor(@PathVariable Long id){
        return new ResponseEntity<>(service.fetchBooksOfAuthorById(id),HttpStatus.OK);
    }



    @GetMapping("/author/paging/{id}")
    public ResponseEntity<?> getPageBooksFromAuthor(@PathVariable(value = "id") Long id,
                                                    @RequestParam(value = "offset",defaultValue = "0") int offset,@RequestParam(value = "size",defaultValue = "1") int size)
    {
        return new ResponseEntity<>(service.fetchPageBooksOfAuthority(id,offset,size),HttpStatus.OK);
    }

    @DeleteMapping("/author/{id}")
    public ResponseEntity<?> fetchBookByAuthorIdAndDeleteFirst(@PathVariable Long id){
        return new ResponseEntity<>(service.fetchBooksOfAuthorByIdAndDeleteFirstBook(id),HttpStatus.OK);
    }
}
