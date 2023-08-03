package com.api.entity;

//import com.api.dto.CustomerType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;

import java.time.LocalDate;
public class Product {
    @Id
    private Integer ProductId;
    private String ProductName;
    private String ProductDesp;
    private LocalDate Expirydate;
    //@Enumerated(value= EnumType.STRING)
    //private CustomerType customerType;
    public Integer getProductId() {
        return ProductId;
    }
    public void setProductId(Integer ProductId) {
        this.ProductId = ProductId;
    }
    public String getProductName() {
        return ProductName;
    }
    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }
    public String getProductDesp() {
        return ProductDesp;
    }
    public void setProductDesp(String ProductDesp) {
        this.ProductDesp = ProductDesp;
    }
    public LocalDate getExpirydate() {
        return Expirydate;
    }
    public void setExpirydate(LocalDate Expirydate) {
        this.Expirydate = Expirydate;
    }

    @Override
    public String toString() {
        return "Product [ProductId=" + ProductId + ", ProductName=" + ProductName + ", ProductDesp" + ProductDesp + ", Expirydate="
                + Expirydate + "]";
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.getProductId() == null) ? 0 : this.getProductId().hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Product other = (Product) obj;
        if (this.getProductId() == null) {
            if (other.getProductId() != null)
                return false;
        }
        else if (!this.getProductId().equals(other.getProductId()))
            return false;
        return true;
    }
}
