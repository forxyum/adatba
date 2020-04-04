package hu.bois.demo.repository;

import hu.bois.demo.model.Price;
import hu.bois.demo.model.identifier.PriceId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin(origins="http://localhost:4200")
public interface PriceRepository extends JpaRepository<Price, PriceId>{

}
