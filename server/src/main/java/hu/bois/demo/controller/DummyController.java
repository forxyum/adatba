package hu.bois.demo.controller;

import hu.bois.demo.repository.CustomerRepository;
import hu.bois.demo.repository.DummyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins ="http://localhost:4200")
@RestController
public class DummyController {
    @Autowired
    private DummyRepository repository;
    public DummyController(DummyRepository repo){
        this.repository = repo;
    }
    @GetMapping("/stats/numofauth")
    public List<Object[]> getNumberOfAuthors(){
        return repository.numberOfAuthors();
    }
    @GetMapping("/stats/bookpergenre")
    public List<Object[]> getBooksPerGenre(){
        return repository.bookPerGenre();
    }
    @GetMapping("/stats/avgprice")
    public List<Object[]> getAvgPrice(){
        return repository.avgPrice();
    }
    @GetMapping("/stats/avgwhole")
    public List<Object[]> getAvgWhole(){
        return repository.avgWhole();
    }
    @GetMapping("/stats/morethan")
    public List<Object[]> getMoreThanAvg(){
        return repository.moreThanAvg();
    }
    @GetMapping("/stats/somofprice")
    public List<Object[]> getSumOfPurchases(){
        return repository.sumOfPurchases();
    }
    @GetMapping("/stats/sumofpriceper")
    public List<Object[]> getSumOfPurchasesPer(){
        return repository.sumOfPurchasesPer();
    }
    @GetMapping("/stats/employeeper")
    public List<Object[]> getEmployeePer(){
        return repository.employePer();
    }
    @GetMapping("/stats/bookpercust")
    public List<Object[]> getBookPerCust(){
        return repository.bookPerCust();
    }
    @GetMapping("/stats/bookperstore")
    public List<Object[]> getBookPerStore(){
        return repository.bookPerStore();
    }
    @GetMapping("/stats/mostauth")
    public List<Object[]> getMostAuthor(){
        return repository.mostAuthor();
    }
    @GetMapping("/stats/mostgenre")
    public List<Object[]> getMostGenre(){
        return repository.mostGenre();
    }
}
