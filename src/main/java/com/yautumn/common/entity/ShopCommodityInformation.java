package com.yautumn.common.entity;

import lombok.Data;

@Data
public class ShopCommodityInformation {
    private String id;

    private String shopId;

    private String productName;

    private String productType;

    private String productSpecific;

    private String productUnit;

    private String status;

    private String createtime;

    private String updatetime;

    private String remark;

}