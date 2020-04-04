package hu.bois.demo.repository;

import hu.bois.demo.model.Purchase;
import hu.bois.demo.model.identifier.PurchaseId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.sql.Timestamp;
import java.util.List;

@RepositoryRestResource
@CrossOrigin(origins="http://localhost:4200")
public interface PurchaseRepository extends JpaRepository<Purchase, PurchaseId>{
    @Query(value = "SELECT * FROM purchase WHERE customer = ?1 AND purchase_time = ?2",nativeQuery = true)
    public List<Purchase> getPurchaseByCustomerAndTime(@Param("customer")String customer, @Param("purchase_time")Timestamp time);

    @Query(value = "SELECT * from purchase WHERE customer = ?1", nativeQuery = true)
    public List<Purchase> getPurchasesByCustomer(@Param("customer")String customer);
}
