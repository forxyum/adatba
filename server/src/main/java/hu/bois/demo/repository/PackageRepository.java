package hu.bois.demo.repository;

import hu.bois.demo.dto.PackageDTO;
import hu.bois.demo.model.identifier.PackageId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import hu.bois.demo.model.Package;

import java.util.List;

@RepositoryRestResource
@CrossOrigin(origins="http://localhost:4200")
public interface PackageRepository extends JpaRepository<Package, PackageId>{
    @Query(value = "SELECT * FROM package WHERE supply_id=?1",nativeQuery = true)
    public List<Package> findPackagesBySupply(@Param("supply_id") Long id);

}
