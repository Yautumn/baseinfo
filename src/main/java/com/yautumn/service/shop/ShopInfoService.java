package com.yautumn.service.shop;

import com.yautumn.common.entity.shop.ShopInfo;
import com.yautumn.common.utils.PageBeanUtil;
import com.yautumn.param.request.common.PageParam;
import com.yautumn.param.request.shop.ShopParam;
import org.springframework.stereotype.Service;

@Service
public interface ShopInfoService {

    String insert(ShopParam shopParam);

    String delShopByID(String shopId);

    String updateShop(ShopParam shopParam);

    ShopInfo findShopById(String shopId);

    PageBeanUtil findShopAll(PageParam pageParam);

    int countShop();
}
