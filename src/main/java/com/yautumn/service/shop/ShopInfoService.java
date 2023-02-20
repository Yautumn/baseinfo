package com.yautumn.service.shop;

import com.yautumn.common.entity.ShopInfo;
import com.yautumn.common.utils.PageBeanUtil;
import com.yautumn.param.request.shop.ShopParam;
import org.springframework.stereotype.Service;

@Service
public interface ShopInfoService {

    String insert(ShopParam shopParam);

    String delShopByID(ShopParam shopParam);

    String updateShop(ShopParam shopParam);

    ShopInfo findShopById(ShopParam shopParam);

    PageBeanUtil findShopAll(ShopParam shopParam);

    int countShop();
}
