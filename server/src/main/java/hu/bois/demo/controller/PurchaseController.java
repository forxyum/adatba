package hu.bois.demo.controller;

import hu.bois.demo.model.Customer;
import hu.bois.demo.model.Purchase;
import hu.bois.demo.repository.PurchaseRepository;
import oracle.jdbc.proxy.annotation.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class PurchaseController {
    @Autowired
    private PurchaseRepository repository;

    public PurchaseController(PurchaseRepository repo) {
        this.repository = repo;
    }

    @GetMapping("/purchases")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Purchase> getAllPurchases() {
        return repository.findAll();
    }

    //TODO: get by customer + puchase time
    @PostMapping("/purchases")
    public Purchase createPurchase(Purchase pur) {
        return repository.save(pur);
    }
}
