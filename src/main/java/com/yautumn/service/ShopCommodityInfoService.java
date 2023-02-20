package com.yautumn.service;

import com.yautumn.common.entity.ShopCommodityInformation;
import com.yautumn.common.utils.PageBeanUtil;
import com.yautumn.param.request.ShopCommodityParam;
import org.springframework.stereotype.Service;

@Service
public interface ShopCommodityInfoService {

    String insert(ShopCommodityParam shopCommodityParam);

    String delShopCommodityByID(ShopCommodityParam shopCommodityParam);

    String updateCommdityByID(ShopCommodityParam shopCommodityParam);

    PageBeanUtil findCommdityAll(ShopCommodityParam shopCommodityParam);

    ShopCommodityInformation findShopCommodityByID(ShopCommodityParam shopCommodityParam);

    int countCommoditys();
}
