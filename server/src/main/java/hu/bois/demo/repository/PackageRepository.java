package hu.bois.demo.repository;

import hu.bois.demo.model.identifier.PackageId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import hu.bois.demo.model.Package;

@RepositoryRestResource
@CrossOrigin(origins="http://localhost:4200")
public interface PackageRepository extends JpaRepository<Package, PackageId>{

}
