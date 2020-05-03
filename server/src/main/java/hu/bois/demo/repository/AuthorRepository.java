package hu.bois.demo.repository;

import hu.bois.demo.model.Author;
import hu.bois.demo.model.Package;
import hu.bois.demo.model.identifier.AuthorId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RepositoryRestResource
@CrossOrigin(origins="http://localhost:4200")
public interface AuthorRepository extends JpaRepository<Author, AuthorId>{
    @Query(value = "SELECT * FROM package WHERE supply_id=?1",nativeQuery = true)
    public List<Package> findPackagesBySupply(@Param("supply_id") Long id);

    @Query(value = "SELECT * FROM author WHERE book_id=?1",nativeQuery = true)
    public List<Author> findAuthorByBookId(@Param("book_id") Long id);

}
