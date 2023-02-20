package com.yautumn.param.request.shop;

import com.yautumn.param.request.common.PageParam;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShopCommodityParam {
    private String id;

    private String shopId;

    private String productName;

    private String productType;

    private String productSpecific;

    private String productUnit;

    private String createtime;

    private String updatetime;

    private String remark;

    private PageParam pageParam;

}