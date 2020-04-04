package hu.bois.demo.model;

import hu.bois.demo.model.identifier.StockId;
import lombok.NonNull;

import javax.persistence.*;

@Entity
@Table(name="stock")
@IdClass(StockId.class)
public class Stock {
    @Column(name="store_address")
    @Id private @NonNull String storeAddress;
    @Column(name="book_id")
    @Id private @NonNull Long bookId;
    @Column(name="amount")
    private @NonNull int amount;

    public Stock(@NonNull String storeAddress, @NonNull Long bookId, @NonNull int amount) {
        this.storeAddress = storeAddress;
        this.bookId = bookId;
        this.amount = amount;
    }

    public Stock() {
    }

    public String getStoreAddress() {
        return storeAddress;
    }

    public void setStoreAddress(String store_address) {
        this.storeAddress = store_address;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long book_id) {
        this.bookId = book_id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
