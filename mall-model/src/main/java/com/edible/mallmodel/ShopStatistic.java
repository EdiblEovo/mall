package com.edible.mallmodel;

import java.math.BigDecimal;

public class ShopStatistic {
    private Integer shopId;

    private Integer productCount;

    private Integer orderCount;

    private BigDecimal incomeAmount;

    private BigDecimal feeAmount;

    private BigDecimal advertiseAmount;

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public Integer getProductCount() {
        return productCount;
    }

    public void setProductCount(Integer productCount) {
        this.productCount = productCount;
    }

    public Integer getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(Integer orderCount) {
        this.orderCount = orderCount;
    }

    public BigDecimal getIncomeAmount() {
        return incomeAmount;
    }

    public void setIncomeAmount(BigDecimal incomeAmount) {
        this.incomeAmount = incomeAmount;
    }

    public BigDecimal getFeeAmount() {
        return feeAmount;
    }

    public void setFeeAmount(BigDecimal feeAmount) {
        this.feeAmount = feeAmount;
    }

    public BigDecimal getAdvertiseAmount() {
        return advertiseAmount;
    }

    public void setAdvertiseAmount(BigDecimal advertiseAmount) {
        this.advertiseAmount = advertiseAmount;
    }
}