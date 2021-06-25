package com.edible.mallservice.impl;

import com.edible.malldao.ReturnItemDao;
import com.edible.mallmodel.ReturnItem;
import com.edible.mallservice.ReturnItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ReturnItemServiceImpl implements ReturnItemService {

    @Autowired
    private ReturnItemDao returnItemDao;

    @Override
    public int createReturnItem(ReturnItem returnItem) {
        return returnItemDao.insert(returnItem);
    }

    @Override
    public List<ReturnItem> getReturnItemByOrderId(int orderId) {
        return returnItemDao.selectByOrderId(orderId);
    }

    @Override
    public BigDecimal getReturnPriceByOrderId(int orderId) {
        List<ReturnItem> returnItemList = returnItemDao.selectByOrderId(orderId);
        BigDecimal returnPrice = new BigDecimal(0);
        for (ReturnItem returnItem : returnItemList) {
            returnPrice.add(getReturnPriceByReturnItem(returnItem));
        }
        return returnPrice;
    }

    @Override
    public BigDecimal getReturnPriceByReturnItem(ReturnItem returnItem) {
        return returnItem.getProductPrice().multiply(new BigDecimal(returnItem.getReturnQuantity()));
    }
}
