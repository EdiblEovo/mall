package com.edible.mallservice;

import com.edible.mallmodel.OrderItem;

import java.math.BigDecimal;
import java.util.List;

public interface OrderItemService {
    BigDecimal createOrderItem(int productId, int orderId, int quantity);

    List<OrderItem> getOrderItemByOrderId(int orderId);
}
