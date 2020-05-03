package hu.bois.demo.controller;

import hu.bois.demo.model.Book;
import hu.bois.demo.model.Contract;
import hu.bois.demo.model.Customer;
import hu.bois.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins ="http://localhost:4200")
@RestController
public class CustomerController {
    @Autowired
    private CustomerRepository repository;

    public CustomerController(CustomerRepository repo) {
        this.repository = repo;
    }

    @GetMapping("/customers")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Customer> getAllCustomers() {
        return repository.findAll();
    }

    @GetMapping("/customers/{id}")
    public ResponseEntity<Customer> getCustomerByUsername(@PathVariable(value = "id") String username) throws ResourceNotFoundException {
        Customer cust = repository.findById(username)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found for this username: " + username));
        return ResponseEntity.ok().body(cust);
    }

    @PostMapping("/customers")
    public Customer createCustomer(@Valid @RequestBody Customer cust) {
        return repository.save(cust);
    }
}
