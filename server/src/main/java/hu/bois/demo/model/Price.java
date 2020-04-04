package hu.bois.demo.model;

import hu.bois.demo.model.identifier.PriceId;
import lombok.NonNull;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name="price")
@IdClass(PriceId.class)
public class Price {
    @Id private @NonNull Long bookId;
    private @NonNull int wholesale;
    private @NonNull int sale;
    @Id private @NonNull String storeAddress;

    public Price(@NonNull Long bookId, @NonNull int wholesale, @NonNull int sale, @NonNull String storeAddress) {
        this.bookId = bookId;
        this.wholesale = wholesale;
        this.sale = sale;
        this.storeAddress = storeAddress;
    }

    public Price() {
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long book_id3) {
        this.bookId = book_id3;
    }

    public int getWholesale() {
        return wholesale;
    }

    public void setWholesale(int wholesale) {
        this.wholesale = wholesale;
    }

    public int getSale() {
        return sale;
    }

    public void setSale(int sale) {
        this.sale = sale;
    }

    public String getStoreAddress() {
        return storeAddress;
    }

    public void setStoreAddress(String store_address) {
        this.storeAddress = store_address;
    }
}
