package hu.bois.demo.controller;

import hu.bois.demo.model.Customer;
import hu.bois.demo.model.Purchase;
import hu.bois.demo.repository.PurchaseRepository;
import oracle.jdbc.proxy.annotation.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
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
    @GetMapping("purchases/{customer}/{time}")
    public ResponseEntity<List<Purchase>> getPurchasesByCustomerAndTime(@PathVariable(value = "customer") String username,@PathVariable(value="time") Timestamp time) throws ResourceNotFoundException {
        List<Purchase> purchases = repository.getPurchaseByCustomerAndTime(username,time);
        return ResponseEntity.ok().body(purchases);
    }
    @GetMapping("purchases/{customer}")
    public ResponseEntity<List<Purchase>> getPurchasesByCustomer(@PathVariable(value="customer") String username){
        List<Purchase> purchases = repository.getPurchasesByCustomer(username);
        return ResponseEntity.ok().body(purchases);
    }

    @PostMapping("/purchases")
    public Purchase createPurchase(Purchase pur) {
        return repository.save(pur);
    }
}
