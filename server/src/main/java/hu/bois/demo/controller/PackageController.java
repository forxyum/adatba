package hu.bois.demo.controller;

import hu.bois.demo.dto.PackageDTO;
import hu.bois.demo.model.Book;
import hu.bois.demo.model.Customer;
import hu.bois.demo.model.Supply;
import hu.bois.demo.repository.BookRepository;
import hu.bois.demo.repository.PackageRepository;
import hu.bois.demo.model.Package;
import hu.bois.demo.repository.SupplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class PackageController {
    @Autowired
    private PackageRepository repository;
    @Autowired
    private BookRepository bookrepo;
    @Autowired
    private SupplyRepository supprepo;

    public PackageController(PackageRepository repo) {
        this.repository = repo;
    }

    @GetMapping("/packages")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Package> getAllPackages() {
        return repository.findAll();
    }

    @GetMapping("packages/{id}")
    public List<PackageDTO> getPackagesBySupplyId(@PathVariable(value = "id") Long id) {
        return repository.findPackagesBySupply(id).stream().map(e -> PackageDTO.toDTO(e)).collect(Collectors.toList());
    }

    @PostMapping("/packages")
    public Package createPackage(@Valid @RequestBody PackageDTO pack) {
        Book book = bookrepo.findById(pack.getBookId()).orElseThrow(RuntimeException::new);
        Supply supp = supprepo.findById(pack.getSupplyId()).orElseThrow(RuntimeException::new);
        return repository.save(PackageDTO.toEntity(pack,book,supp));
    }
    @PostMapping("packages/remove")
    public void deletePackage(@Valid @RequestBody PackageDTO pack){
        Book book = bookrepo.findById(pack.getBookId()).orElseThrow(RuntimeException::new);
        Supply supp = supprepo.findById(pack.getSupplyId()).orElseThrow(RuntimeException::new);
        repository.delete(PackageDTO.toEntity(pack,book,supp));
    }


}
