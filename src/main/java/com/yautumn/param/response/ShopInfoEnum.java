package com.yautumn.param.response;

import lombok.AllArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
public enum ShopInfoEnum {

    SUCCESS("操作成功"),

    SHOP_IS_NOT_EXIST("商户信息不存在"),

    SHOP_INSERT_ERROR("商户信息插入失败"),

    SHOP_UPDATE_ERROR("商户信息更新失败"),

    SHOP_DELETE_ERROR("商户删除失败");
    public final String name;

}
