package hu.bois.demo.controller;

import hu.bois.demo.model.Customer;
import hu.bois.demo.repository.PackageRepository;
import hu.bois.demo.model.Package;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class PackageController {
    @Autowired
    private PackageRepository repository;

    public PackageController(PackageRepository repo) {
        this.repository = repo;
    }

    @GetMapping("/packages")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Package> getAllPackages() {
        return repository.findAll();
    }

    //TODO: get packages by suplly id only
    @PostMapping("/packages")
    public Package createPackage(Package pack) {
        return repository.save(pack);
    }
}
