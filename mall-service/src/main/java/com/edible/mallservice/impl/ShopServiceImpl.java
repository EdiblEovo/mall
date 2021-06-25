package com.edible.mallservice.impl;

import com.edible.malldao.ShopDao;
import com.edible.mallmodel.Shop;
import com.edible.mallservice.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ShopDao shopDao;

    @Override
    public int register(Shop shop) {
        shop.setStatus(2);
        return shopDao.insert(shop);
    }

    @Override
    public void registerPassed(int sid) {
        Shop shop = shopDao.selectByPrimaryKey(sid);
        shop.setStatus(1);
        shopDao.updateByPrimaryKey(shop);
    }

    @Override
    public void registerDenied(int sid) {
        Shop shop = shopDao.selectByPrimaryKey(sid);
        shop.setStatus(0);
        shopDao.updateByPrimaryKey(shop);
    }

    @Override
    public boolean checkUsername(String username) {
        return (shopDao.selectByUsername(username)!=null);
    }

    @Override
    public boolean checkShopName(String shopName) {
        return (shopDao.selectByShopName(shopName)!=null);
    }

    @Override
    public Shop login(String username, String password) {
        System.out.println(username);
        System.out.println(password);
        System.out.println(shopDao.login(username, password));
        return shopDao.login(username, password);
    }

    @Override
    public int updateShop(Shop shop) {
        return shopDao.updateByPrimaryKey(shop);
    }

    @Override
    public int deleteShop(Shop shop) {
        return shopDao.deleteByPrimaryKey(shop.getShopId());
    }
}
