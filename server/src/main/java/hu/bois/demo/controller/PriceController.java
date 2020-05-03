package hu.bois.demo.controller;

import hu.bois.demo.model.Customer;
import hu.bois.demo.model.Price;
import hu.bois.demo.model.identifier.PriceId;
import hu.bois.demo.repository.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
@CrossOrigin(origins ="http://localhost:4200")
@RestController
public class PriceController {
    @Autowired
    private PriceRepository repository;

    public PriceController(PriceRepository repo) {
        this.repository = repo;
    }

    @GetMapping("/prices")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Price> getAllPrices() {
        return repository.findAll();
    }

    @GetMapping("/prices/{store}/{book}")
    public ResponseEntity<Price> getPrice(@PathVariable(value = "store") String storeAddress, @PathVariable(value = "book") Long bookId) throws ResourceNotFoundException {
        Price price = repository.findById(new PriceId(bookId, storeAddress))
                .orElseThrow(() -> new ResourceNotFoundException("Price not found for store: " + storeAddress + " book id: " + bookId));
        return ResponseEntity.ok().body(price);
    }

    @PostMapping("/prices")
    public Price createPrice(Price price) {
        return repository.save(price);
    }
}
