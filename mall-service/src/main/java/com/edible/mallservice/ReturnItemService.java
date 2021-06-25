package com.edible.mallservice;

import com.edible.mallmodel.ReturnItem;

import java.math.BigDecimal;
import java.util.List;

public interface ReturnItemService {
    int createReturnItem(ReturnItem returnItem);

    List<ReturnItem> getReturnItemByOrderId(int orderId);

    BigDecimal getReturnPriceByOrderId(int orderId);

    BigDecimal getReturnPriceByReturnItem(ReturnItem returnItem);
}
