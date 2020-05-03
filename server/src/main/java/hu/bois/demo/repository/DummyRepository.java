package hu.bois.demo.repository;

import hu.bois.demo.model.Dummy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RepositoryRestResource
@CrossOrigin(origins="http://localhost:4200")
public interface DummyRepository extends JpaRepository<Dummy, Integer>{

    @Query(value="SELECT genre.genre, count(genre.book_id)\n" +
            "from genre\n" +
            "left join book\n" +
            "on (book.id=genre.book_id)\n" +
            "group by genre.genre",nativeQuery = true)
    public List<Object[]> bookPerGenre();

    @Query(value="SELECT title,COUNT(*) FROM BOOK,AUTHOR WHERE BOOK.id = AUTHOR.book_id group by title",nativeQuery = true)
    public List<Object[]> numberOfAuthors();

    @Query(value="SELECT title,AVG(sale) FROM BOOK,PRICE WHERE BOOK.id=PRICE.book_id group by title",nativeQuery = true)
    public List<Object[]> avgPrice();

    @Query(value="SELECT title,AVG(wholesale) FROM BOOK,PRICE WHERE BOOK.id=PRICE.book_id group by title",nativeQuery = true)
    public List<Object[]> avgWhole();

    @Query(value="SELECT COUNT(*) FROM BOOK,PRICE WHERE BOOK.id = PRICE.BOOK_ID AND PRICE.sale > (SELECT AVG(sale) FROM Price)",nativeQuery = true)
    public List<Object[]> moreThanAvg();

    @Query(value="SELECT username,SUM(sale*purchase.amount) FROM CUSTOMER, PRICE, PURCHASE WHERE purchase.customer=customer.username AND purchase.book_id = price.book_id AND price.store_address=purchase.address group by username",nativeQuery = true)
    public List<Object[]> sumOfPurchases();

    @Query(value="SELECT username,purchase.address,SUM(sale*purchase.amount) FROM CUSTOMER, PRICE, PURCHASE WHERE purchase.customer=customer.username AND purchase.book_id = price.book_id AND price.store_address=purchase.address group by username, purchase.address",nativeQuery = true)
    public List<Object[]> sumOfPurchasesPer();

    @Query(value="SELECT name, COUNT(*) FROM COMPANY, CONTRACT WHERE company.tax_number=contract.company_tax group by name",nativeQuery = true)
    public List<Object[]> employePer();

    @Query(value="SELECT username,SUM(amount) FROM PURCHASE,CUSTOMER,BOOK WHERE BOOK.id = PURCHASE.book_id AND PURCHASE.customer = CUSTOMER.username group by username",nativeQuery = true)
    public List<Object[]> bookPerCust();

    @Query(value="SELECT name,SUM(amount) FROM STORE,STOCK WHERE STORE.address = STOCK.store_address group by name",nativeQuery = true)
    public List<Object[]> bookPerStore();

    @Query(value="SELECT * FROM (SELECT title, count(*) AS number_ FROM BOOK,AUTHOR where book.id = author.book_id group by title order by number_ DESC) where rownum =1",nativeQuery = true)
    public List<Object[]> mostAuthor();

    @Query(value="SELECT * FROM (SELECT title, count(*) AS number_ FROM BOOK,GENRE where book.id = genre.book_id group by title order by number_ DESC) where rownum =1",nativeQuery = true)
    public List<Object[]> mostGenre();

}
