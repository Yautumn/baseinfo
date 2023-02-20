package com.yautumn.service.shop;

import com.yautumn.common.entity.ShopCommodityInformation;
import com.yautumn.common.utils.PageBeanUtil;
import com.yautumn.param.request.shop.ShopCommodityParam;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ShopCommodityInfoService {

    String insert(ShopCommodityParam shopCommodityParam);

    String delShopCommodityByID(ShopCommodityParam shopCommodityParam);

    String updateCommdityByID(ShopCommodityParam shopCommodityParam);

    PageBeanUtil findCommdityAll(ShopCommodityParam shopCommodityParam);

    ShopCommodityInformation findShopCommodityByID(ShopCommodityParam shopCommodityParam);

    int countCommoditys();

    String batchInsert(List<ShopCommodityParam> shopCommodityParams);
}
