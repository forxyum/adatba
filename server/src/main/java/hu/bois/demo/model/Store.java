package hu.bois.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name="store")
public class Store {
    @Id private @NonNull String address;
    private @NonNull int profit;
    private @NonNull String name;

    public Store(@NonNull String address, @NonNull int profit, @NonNull String name) {
        this.address = address;
        this.profit = profit;
        this.name = name;
    }

    public Store() {
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getProfit() {
        return profit;
    }

    public void setProfit(int profit) {
        this.profit = profit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
