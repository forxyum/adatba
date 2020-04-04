package hu.bois.demo.model;

import lombok.NonNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="company")
public class Company {
    @Column(name="tax_number")
    @Id private @NonNull int taxNumber;
    @Column(name="profit")
    private @NonNull Long profit;
    @Column(name="name")
    private @NonNull String name;

    public Company(@NonNull int taxNumber, @NonNull Long profit, @NonNull String name) {
        this.taxNumber = taxNumber;
        this.profit = profit;
        this.name = name;
    }

    public Company() {
    }

    public int getTaxNumber() {
        return taxNumber;
    }

    public void setTaxNumber(int tax_number) {
        this.taxNumber = tax_number;
    }

    public @NonNull Long getProfit() {
        return profit;
    }

    public void setProfit(@NonNull Long profit) {
        this.profit = profit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
