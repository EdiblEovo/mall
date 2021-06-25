package com.edible.mallservice;

import com.edible.mallmodel.Order;

import java.util.List;

public interface OrderService {
    int createOrder(Order order);

    int deleteOrder(Order order);

    int updateOrderStatus(int orderId, int status);

    int updateOrder(Order order);

    Order getOrderByOrderId(int orderId);

    List<Order> getOrderByShopId(int shopId);

    List<Order> getOrderByMemberId(int memberId);
}
