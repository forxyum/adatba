package hu.bois.demo.model;

import hu.bois.demo.model.identifier.PurchaseId;
import lombok.NonNull;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="purchase")
@IdClass(PurchaseId.class)
public class Purchase {
    @Column(name="customer")
    @Id private @NonNull String customer;
    @Column(name="book_id")
    @Id private @NonNull Long bookId;
    @Column(name="amount")
    private @NonNull Integer amount;
    @Column(name="purchase_time")
    @Id private @NonNull Timestamp purchaseTime;
    @Column(name="address")
    private @NonNull String address;
    @Column(name="delivery")
    private  @NonNull Boolean delivery;

    public Purchase(@NonNull String customer, @NonNull Long bookId, @NonNull Integer amount, @NonNull Timestamp purchaseTime, @NonNull String address, @NonNull Boolean delivery) {
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

    public @NonNull Integer getAmount() {
        return amount;
    }

    public void setAmount(@NonNull Integer amount) {
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
