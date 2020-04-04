package hu.bois.demo.controller;

import hu.bois.demo.model.Company;
import hu.bois.demo.model.Contract;
import hu.bois.demo.model.identifier.ContractId;
import hu.bois.demo.repository.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ContractController {
    @Autowired
    private ContractRepository repository;

    public ContractController(ContractRepository repo) {
        this.repository = repo;
    }

    @GetMapping("/contracts")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Contract> getAllContracts() {
        return repository.findAll();
    }

    @GetMapping("/contracts/{company}/{supplier}")
    public ResponseEntity<Contract> getContract(@PathVariable(value = "company") int taxNumber, @PathVariable(value = "supplier") String supplier) throws ResourceNotFoundException {
        Contract cont = repository.findById(new ContractId(supplier, taxNumber))
                .orElseThrow(() -> new ResourceNotFoundException("Company was not found for this tax number :" + taxNumber));
        return ResponseEntity.ok().body(cont);
    }

    @PostMapping("/contracts")
    public Contract createContract(@Valid @RequestBody Contract cont) {
        return repository.save(cont);
    }
}

