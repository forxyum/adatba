package hu.bois.demo.model;

import lombok.NonNull;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="supply")
public class Supply {
    @Id @GeneratedValue
    @Column(name="id")
    private @NonNull Long id;
    @Column(name="supplier_username")
    private @NonNull String supplierName;
    @Column(name="store_address")
    private @NonNull String storeAddress;
    @Column(name="supply_date")
    private @NonNull Date supplyDate;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Package> packages;


    public Supply(@NonNull String supplierName, @NonNull String storeAddress, @NonNull Date supplyDate) {
        this.supplierName = supplierName;
        this.storeAddress = storeAddress;
        this.supplyDate = supplyDate;
    }

    public Supply() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplier_name) {
        this.supplierName = supplier_name;
    }

    public String getStoreAddress() {
        return storeAddress;
    }

    public void setStoreAddress(String store_address) {
        this.storeAddress = store_address;
    }

    public Date getSupplyDate() {
        return supplyDate;
    }

    public void setSupplyDate(Date supply_date) {
        this.supplyDate = supply_date;
    }


}
