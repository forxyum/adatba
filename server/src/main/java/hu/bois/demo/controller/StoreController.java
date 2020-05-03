package hu.bois.demo.controller;

import hu.bois.demo.model.Book;
import hu.bois.demo.model.Store;
import hu.bois.demo.repository.StoreRepository;
import oracle.jdbc.proxy.annotation.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
@CrossOrigin(origins ="http://localhost:4200")
@RestController
public class StoreController {
    @Autowired
    private StoreRepository repository;

    public StoreController(StoreRepository repo) {
        this.repository = repo;
    }

    @GetMapping("/stores")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Store> getAllStores() {
        return repository.findAll();
    }

    @GetMapping("/stores/{address}")
    public ResponseEntity<Store> getStoreByAddress(@PathVariable(value = "address") String address) throws ResourceNotFoundException {
        Store store = repository.findById(address)
                .orElseThrow(() -> new ResourceNotFoundException("Store not found for this address: " + address));
        return ResponseEntity.ok().body(store);
    }

    @PostMapping("/stores")
    public Store createStore(Store st) {
        return repository.save(st);
    }
}
