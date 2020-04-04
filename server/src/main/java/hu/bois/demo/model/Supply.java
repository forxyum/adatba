package hu.bois.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="supply")
public class Supply {
    @Id @GeneratedValue
    private @NonNull Long id;
    private @NonNull String supplier_name;
    private @NonNull String store_address;
    private @NonNull Date supply_date;

    public Supply(@NonNull String supplier_name, @NonNull String store_address, @NonNull Date supply_date) {
        this.supplier_name = supplier_name;
        this.store_address = store_address;
        this.supply_date = supply_date;
    }

    public Supply() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSupplier_name() {
        return supplier_name;
    }

    public void setSupplier_name(String supplier_name) {
        this.supplier_name = supplier_name;
    }

    public String getStore_address() {
        return store_address;
    }

    public void setStore_address(String store_address) {
        this.store_address = store_address;
    }

    public Date getSupply_date() {
        return supply_date;
    }

    public void setSupply_date(Date supply_date) {
        this.supply_date = supply_date;
    }
}
