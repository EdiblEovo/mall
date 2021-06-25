package com.edible.mallservice.impl;

import com.edible.malldao.OrderDao;
import com.edible.mallmodel.Order;
import com.edible.mallservice.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;

    @Override
    public int createOrder(Order order) {
        return orderDao.insert(order);
    }

    @Override
    public int deleteOrder(Order order) {
        return orderDao.deleteByPrimaryKey(order.getOrderId());
    }

    @Override
    public int updateOrderStatus(int orderId, int status) {
        return orderDao.updateStatusByOrderId(orderId, status);
    }

    @Override
    public int updateOrder(Order order) {return orderDao.updateByPrimaryKey(order);}

    @Override
    public Order getOrderByOrderId(int orderId) {return orderDao.selectByPrimaryKey(orderId);}

    @Override
    public List<Order> getOrderByShopId(int shopId) {
        return orderDao.selectByShopId(shopId);
    }

    @Override
    public List<Order> getOrderByMemberId(int memberId) {
        return orderDao.selectByMemberId(memberId);
    }
}
