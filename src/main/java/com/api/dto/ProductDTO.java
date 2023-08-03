package com.api.dto;

import java.time.LocalDate;
public class ProductDTO {
    private Integer ProductId;
    private String ProductName;
    private String ProductDesp;
    private LocalDate Expirydate;
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
}
