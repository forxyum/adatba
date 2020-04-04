package hu.bois.demo.controller;

import hu.bois.demo.model.Customer;
import hu.bois.demo.model.Genre;
import hu.bois.demo.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class GenreController {
    @Autowired
    private GenreRepository repository;

    public GenreController(GenreRepository repo) {
        this.repository = repo;
    }

    @GetMapping("/genres")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Genre> getAllGenres() {
        return repository.findAll();
    }

    //TODO: genre by id / book by genre

    @PostMapping("/genres")
    public Genre createGenre(Genre gen) {
        return repository.save(gen);
    }
}
