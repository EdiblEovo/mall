package com.edible.mallservice;

import com.edible.mallmodel.AdvertiseOrder;

public interface AdvertiseOrderService {
    int createAdvertiseOrder(AdvertiseOrder advertiseOrder);

    int deleteAdvertiseOrder(AdvertiseOrder advertiseOrder);

    int stopAdvertiseOrder(AdvertiseOrder advertiseOrder);

    int countAdvertise(AdvertiseOrder advertiseOrder);

    int endAdvertiseOrder(AdvertiseOrder advertiseOrder);
}
