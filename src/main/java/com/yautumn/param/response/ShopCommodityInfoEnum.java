package com.yautumn.param.response;

import lombok.AllArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
public enum ShopCommodityInfoEnum {

    SUCCESS("操作成功"),

    SHOP_IS_NOT_EXIST("商品信息不存在"),

    SHOP_INSERT_ERROR("商品信息插入失败"),

    SHOP_UPDATE_ERROR("商品信息更新失败"),

    SHOP_BATCH_INSERT_ERROR("商品信息批量插入失败"),

    SHOP_BATCH_UPDATE_ERROR("商品信息批量更新失败"),

    SHOP_DELETE_ERROR("商品删除失败");
    public final String name;

}
