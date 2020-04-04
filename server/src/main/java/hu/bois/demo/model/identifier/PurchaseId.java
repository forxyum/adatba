package hu.bois.demo.model.identifier;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

public class PurchaseId implements Serializable {
    private String customer;
    private Long bookId;
    private Timestamp purchaseTime;

    public PurchaseId(String customer, Long bookId, Timestamp purchaseTime) {
        this.customer = customer;
        this.bookId = bookId;
        this.purchaseTime = purchaseTime;
    }

    public PurchaseId() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PurchaseId)) return false;
        PurchaseId that = (PurchaseId) o;
        return customer.equals(that.customer) &&
                bookId.equals(that.bookId) &&
                purchaseTime.equals(that.purchaseTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customer, bookId, purchaseTime);
    }
}
