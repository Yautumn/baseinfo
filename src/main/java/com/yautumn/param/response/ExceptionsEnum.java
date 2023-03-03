package com.yautumn.param.response;

import lombok.AllArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
public enum ExceptionsEnum {
    SUCCESS("操作成功"),

    MARKET_IS_NOT_EXIST("市场信息不存在"),

    MARKET_INSERT_ERROR("市场信息插入失败"),

    MARKET_UPDATE_ERROR("市场信息更新失败"),

    MARKET_DELETE_ERROR("市场删除失败"),

    SHOP_IS_NOT_EXIST("商品信息不存在"),

    SHOP_INSERT_ERROR("商品信息插入失败"),

    SHOP_UPDATE_ERROR("商品信息更新失败"),

    SHOP_BATCH_INSERT_ERROR("商品信息批量插入失败"),

    SHOP_BATCH_UPDATE_ERROR("商品信息批量更新失败"),

    SHOP_DELETE_ERROR("商品删除失败"),

    SHOP_FACTORY_IS_NOT_EXIST("商户厂商信息不存在"),

    SHOP_FACTORY_INSERT_ERROR("商户厂商信息插入失败"),

    SHOP_FACTORY_UPDATE_ERROR("商户厂商信息更新失败"),

    SHOP_FACTORY_DELETE_ERROR("商户厂商删除失败"),
    
    MEMBER_IS_NOT_EXIST("成员信息不存在"),

    MEMBER_IS_MAX("商户成员已达上限"),

    MEMBER_ADMIN_IS_ONLY_ONE("店铺管理员只能有一个"),

    MEMBER_INSERT_ERROR("商户成员信息插入失败"),

    MEMBER_DELETE_ERROR("商户成员删除失败");

    public final String name;
}
