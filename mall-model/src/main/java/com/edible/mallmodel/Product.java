package com.edible.mallmodel;

import java.math.BigDecimal;

public class Product {
    private Integer productId;

    private Integer shopId;

    private String productName;

    private BigDecimal productPrice;

    private Integer stock;

    private Integer soldQuantity;

    private Integer monthlySoldQuantity;

    private BigDecimal advertisePrice;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getSoldQuantity() {
        return soldQuantity;
    }

    public void setSoldQuantity(Integer soldQuantity) {
        this.soldQuantity = soldQuantity;
    }

    public Integer getMonthlySoldQuantity() {
        return monthlySoldQuantity;
    }

    public void setMonthlySoldQuantity(Integer monthlySoldQuantity) {
        this.monthlySoldQuantity = monthlySoldQuantity;
    }

    public BigDecimal getAdvertisePrice() {
        return advertisePrice;
    }

    public void setAdvertisePrice(BigDecimal advertisePrice) {
        this.advertisePrice = advertisePrice;
    }
}