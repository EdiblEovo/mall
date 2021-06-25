package com.edible.mallmodel;

import java.math.BigDecimal;
import java.util.Date;

public class AdvertiseOrder {
    private Integer advertiseId;

    private Integer shopId;

    private Integer productId;

    private BigDecimal advertisePrice;

    private Integer advertiseCount;

    private Date startTime;

    private Date endTime;

    public Integer getAdvertiseId() {
        return advertiseId;
    }

    public void setAdvertiseId(Integer advertiseId) {
        this.advertiseId = advertiseId;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public BigDecimal getAdvertisePrice() {
        return advertisePrice;
    }

    public void setAdvertisePrice(BigDecimal advertisePrice) {
        this.advertisePrice = advertisePrice;
    }

    public Integer getAdvertiseCount() {
        return advertiseCount;
    }

    public void setAdvertiseCount(Integer advertiseCount) {
        this.advertiseCount = advertiseCount;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}