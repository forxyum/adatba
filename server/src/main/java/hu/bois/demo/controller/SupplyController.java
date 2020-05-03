package hu.bois.demo.controller;

import hu.bois.demo.model.Book;
import hu.bois.demo.model.Supply;
import hu.bois.demo.repository.SupplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
@CrossOrigin(origins ="http://localhost:4200")
@RestController
public class SupplyController {
    @Autowired
    private SupplyRepository repository;

    public SupplyController(SupplyRepository repo) {
        this.repository = repo;
    }

    @GetMapping("/supplies")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Supply> getAllSupply() {
        return repository.findAll();
    }

    @GetMapping("/supplies/{id}")
    public ResponseEntity<Supply> getSupplyById(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
        Supply supp = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Supply not found for id:" + id));
        return ResponseEntity.ok().body(supp);
    }

    @PostMapping("/supplies")
    public Supply saveSupply(Supply supp) {
        return repository.save(supp);
    }
}
