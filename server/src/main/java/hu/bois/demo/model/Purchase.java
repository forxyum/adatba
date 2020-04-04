package hu.bois.demo.model;

import hu.bois.demo.model.identifier.PurchaseId;
import lombok.NonNull;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name="purchase")
@IdClass(PurchaseId.class)
public class Purchase {
    @Id private @NonNull String customer;
    @Id private @NonNull Long bookId;
    private @NonNull int amount;
    @Id private @NonNull Timestamp purchaseTime;
    private @NonNull String address;
    private  @NonNull Boolean delivery;

    public Purchase(@NonNull String customer, @NonNull Long bookId, @NonNull int amount, @NonNull Timestamp purchaseTime, @NonNull String address, @NonNull Boolean delivery) {
        this.customer = customer;
        this.bookId = bookId;
        this.amount = amount;
        this.purchaseTime = purchaseTime;
        this.address = address;
        this.delivery = delivery;
    }

    public Purchase() {
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long book_id4) {
        this.bookId = book_id4;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public @NonNull Timestamp getPurchaseTime() {
        return purchaseTime;
    }

    public void setPurchaseTime(@NonNull Timestamp purchase_time) {
        this.purchaseTime = purchase_time;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address2) {
        this.address = address2;
    }

    public Boolean getDelivery() {
        return delivery;
    }

    public void setDelivery(Boolean delivery) {
        this.delivery = delivery;
    }
}
