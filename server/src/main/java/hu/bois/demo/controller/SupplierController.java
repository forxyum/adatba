package hu.bois.demo.controller;

import hu.bois.demo.model.Book;
import hu.bois.demo.model.Supplier;
import hu.bois.demo.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class SupplierController {
    @Autowired
    private SupplierRepository repository;

    public SupplierController(SupplierRepository repo) {
        this.repository = repo;
    }

    @GetMapping("/suppliers")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Supplier> getAllSuppliers() {
        return repository.findAll();
    }

    @GetMapping("/suppliers/{username}")
    public ResponseEntity<Supplier> getSupplierByUsername(@PathVariable(value = "username") String username) throws ResourceNotFoundException {
        Supplier supp = repository.findById(username)
                .orElseThrow(() -> new ResourceNotFoundException("Supplier not found for username: " + username));
        return ResponseEntity.ok().body(supp);
    }

    @PostMapping("/suppliers")
    public Supplier createSupplier(Supplier supp) {
        return repository.save(supp);
    }
}
