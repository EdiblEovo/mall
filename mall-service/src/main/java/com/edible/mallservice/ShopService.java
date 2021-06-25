package com.edible.mallservice;

import com.edible.mallmodel.Shop;

public interface ShopService {
    int register(Shop shop);
    void registerPassed(int sid);
    void registerDenied(int sid);

    boolean checkUsername(String username);

    boolean checkShopName(String shopName);

    Shop login(String username, String password);

    int updateShop(Shop shop);

    int deleteShop(Shop shop);
}
