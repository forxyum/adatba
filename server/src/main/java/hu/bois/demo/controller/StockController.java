package hu.bois.demo.controller;

import hu.bois.demo.model.Book;
import hu.bois.demo.model.Stock;
import hu.bois.demo.model.identifier.StockId;
import hu.bois.demo.repository.StockRepository;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class StockController {
    private StockRepository repository;

    public StockController(StockRepository repo) {
        this.repository = repo;
    }

    @GetMapping("/stocks")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Stock> getAllStocks() {
        return repository.findAll();
    }

    @GetMapping("/stocks/{address}/{id}")
    public ResponseEntity<Stock> geStock(@PathVariable(value = "address") String address, @PathVariable(value = "id") Long bookId) throws ResourceNotFoundException {
        Stock stock = repository.findById(new StockId(address, bookId))
                .orElseThrow(() -> new ResourceNotFoundException("Stock not found in store: " + address + " for book id: " + bookId));
        return ResponseEntity.ok().body(stock);
    }

    //TODO: change to addToStock and implement it
    @PostMapping("/stocks")
    public Stock createStock(Stock stock) {
        return repository.save(stock);
    }
}
