package hu.bois.demo.controller;

import hu.bois.demo.model.Author;
import hu.bois.demo.model.identifier.AuthorId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import hu.bois.demo.repository.AuthorRepository;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins ="http://localhost:4200")
@RestController
public class AuthorController {
    @Autowired
    private AuthorRepository repository;

    public AuthorController(AuthorRepository repo) {
        this.repository = repo;
    }

    @GetMapping("/authors")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Author> getAllAuthors() {
        return repository.findAll();
    }

    @GetMapping("/authors/{author}/{bookId}")
    public ResponseEntity<Author> getAuthor(@PathVariable(value = "bookId") Long bookId, @PathVariable(value = "author") String author) throws ResourceNotFoundException {
        Author auth = repository.findById(new AuthorId(bookId, author))
                .orElseThrow(() -> new ResourceNotFoundException("Author not found"));
        return ResponseEntity.ok().body(auth);
    }
    @GetMapping("/authors/{bookId}")
    public List<Author> getAuthorsByBookId(@PathVariable(value="bookId") Long id){
        return repository.findAuthorByBookId(id);
    }

    @PostMapping("/authors")
    public Author createAuthor(@Valid @RequestBody Author auth) {
        return repository.save(auth);
    }
}
