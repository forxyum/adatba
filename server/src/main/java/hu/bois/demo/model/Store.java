package hu.bois.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="store")
public class Store {
    @Column(name="address")
    @Id private @NonNull String address;
    @Column(name="profit")
    private @NonNull int profit;
    @Column(name="name")
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
