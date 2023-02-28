package com.yautumn.param.response;

import lombok.AllArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
public enum MarketInfoEnum {
    SUCCESS("操作成功"),

    MARKET_IS_NOT_EXIST("市场信息不存在"),

    MARKET_INSERT_ERROR("市场信息插入失败"),

    MARKET_UPDATE_ERROR("市场信息更新失败"),

    MARKET_DELETE_ERROR("市场删除失败");
    public final String name;

}
