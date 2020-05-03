package hu.bois.demo.controller;

import hu.bois.demo.model.Book;
import hu.bois.demo.model.Company;
import hu.bois.demo.repository.CompanyRepository;
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
public class CompanyController {
    @Autowired
    private CompanyRepository repository;

    public CompanyController(CompanyRepository repo){
        this.repository = repo;
    }

    @GetMapping("/companies")
    @CrossOrigin(origins="http://localhost:4200")
    public List<Company> getAllCompanies(){
        return repository.findAll();
    }
    @GetMapping("/companies/{id}")
    public ResponseEntity<Company> getBookById(@PathVariable(value="id") int taxNumber) throws ResourceNotFoundException {
        Company comp = repository.findById(taxNumber)
                .orElseThrow(() -> new ResourceNotFoundException("Company was not found for this tax number :" + taxNumber));
        return ResponseEntity.ok().body(comp);
    }
    @PostMapping("/companies")
    public Company createCompany(@Valid @RequestBody Company comp){
        return repository.save(comp);
    }
}
