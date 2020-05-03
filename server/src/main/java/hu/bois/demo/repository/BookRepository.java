package hu.bois.demo.repository;

import hu.bois.demo.model.Book;
import hu.bois.demo.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@RepositoryRestResource
@CrossOrigin(origins="http://localhost:4200")
public interface BookRepository extends JpaRepository<Book, Long>{
    @Query(value = "select store.name,sale,store.address from STORE,BOOK,STOCK,PRICE WHERE stock.book_id=book.id AND stock.store_address=store.address AND book.id=?1 AND book.id=price.book_id AND price.store_address = store.address",nativeQuery = true)
    public List<Object[]> findStoresThatSell(@Param("book_id") Long id);


    @Query(value="SELECT title,COUNT(*) FROM BOOK,AUTHOR WHERE BOOK.id = AUTHOR.book_id group by title",nativeQuery = true)
    public List<Object[]> numberOfAuthors();
}
