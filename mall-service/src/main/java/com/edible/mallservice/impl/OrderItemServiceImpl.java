package com.edible.mallservice.impl;

import com.edible.malldao.OrderItemDao;
import com.edible.mallmodel.OrderItem;
import com.edible.mallservice.OrderItemService;
import com.edible.mallservice.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class OrderItemServiceImpl implements OrderItemService {

    @Autowired
    private OrderItemDao orderItemDao;

    @Autowired
    private ProductService productService;

    @Override
    public BigDecimal createOrderItem(int productId, int orderId, int quantity) {
        OrderItem orderItem = new OrderItem();
        orderItem.setOrderId(orderId);
        orderItem.setProductId(productId);
        orderItem.setOrderQuantity(quantity);
        BigDecimal price=productService.getProductPriceByProductId(productId);
        orderItem.setProductPrice(price);
        orderItemDao.insert(orderItem);
        return price.multiply(BigDecimal.valueOf(quantity));
    }

    @Override
    public List<OrderItem> getOrderItemByOrderId(int orderId) {
        return orderItemDao.selectByOrderId(orderId);
    }
}
