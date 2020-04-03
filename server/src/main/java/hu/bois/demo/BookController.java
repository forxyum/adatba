package hu.bois.demo;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;
import java.util.stream.Collectors;

public class BookController {
    private BookRepository repository;

    public BookController(BookRepository repo){
        this.repository = repo;
    }
    @GetMapping("/books")
    @CrossOrigin(origins="http://localhost:4200")
    public Collection<Book> books(){
        return repository.findAll().stream().collect(Collectors.toList());
    }
}
