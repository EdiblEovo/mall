package com.edible.mallservice.impl;

import com.edible.malldao.AdvertiseOrderDao;
import com.edible.mallmodel.AdvertiseOrder;
import com.edible.mallmodel.Product;
import com.edible.mallservice.AdvertiseOrderService;
import com.edible.mallservice.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;

@Service
public class AdvertiseOrderServiceImpl implements AdvertiseOrderService {

    @Autowired
    private AdvertiseOrderDao advertiseOrderDao;
    @Autowired
    private ProductService productService;

    @Override
    public int createAdvertiseOrder(AdvertiseOrder advertiseOrder) {
        return advertiseOrderDao.insert(advertiseOrder);
    }

    @Override
    public int deleteAdvertiseOrder(AdvertiseOrder advertiseOrder) {
        return advertiseOrderDao.deleteByPrimaryKey(advertiseOrder.getAdvertiseId());
    }

    @Override
    public int stopAdvertiseOrder(AdvertiseOrder advertiseOrder) {
        advertiseOrder.setEndTime(new Date());
        endAdvertiseOrder(advertiseOrder);
        return advertiseOrderDao.updateByPrimaryKey(advertiseOrder);
    }

    @Override
    public int countAdvertise(AdvertiseOrder advertiseOrder) {
        return 0;
    }

    @Override
    public int endAdvertiseOrder(AdvertiseOrder advertiseOrder) {
        Product product = productService.getProductByProductId(advertiseOrder.getProductId());
        product.setAdvertisePrice(BigDecimal.ZERO);
        return productService.updateProduct(product);
    }
}
