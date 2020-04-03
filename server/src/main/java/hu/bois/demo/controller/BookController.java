package hu.bois.demo.controller;

import hu.bois.demo.model.Book;
import hu.bois.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api")
public class BookController {
    @Autowired
    private BookRepository repository;

    public BookController(BookRepository repo){
        this.repository = repo;
    }

    @GetMapping("/books")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Book> getAllBooks(){

        return repository.findAll();
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable(value="id") Long bookId) throws ResourceNotFoundException{
        Book book = repository.findById(bookId)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found for this id :" + bookId));
        return ResponseEntity.ok().body(book);
    }
    @PostMapping("/books")
    public Book createBook(@Valid @RequestBody Book book){
        return repository.save(book);
    }
}
