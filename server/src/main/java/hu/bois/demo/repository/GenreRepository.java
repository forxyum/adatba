package hu.bois.demo.repository;

import hu.bois.demo.model.Author;
import hu.bois.demo.model.Genre;
import hu.bois.demo.model.identifier.GenreId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RepositoryRestResource
@CrossOrigin(origins="http://localhost:4200")
public interface GenreRepository extends JpaRepository<Genre, GenreId>{

    @Query(value = "SELECT * FROM genre WHERE book_id=?1",nativeQuery = true)
    public List<Genre> findGenreByBookId(@Param("book_id") Long id);
}
