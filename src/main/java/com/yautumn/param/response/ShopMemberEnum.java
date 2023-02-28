package com.yautumn.param.response;

import lombok.AllArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
public enum ShopMemberEnum {

    SUCCESS("操作成功"),

    MEMBER_IS_NOT_EXIST("成员信息不存在"),

    MEMBER_IS_MAX("商户成员已达上限"),

    MEMBER_ADMIN_IS_ONLY_ONE("店铺管理员只能有一个"),

    MEMBER_INSERT_ERROR("商户成员信息插入失败"),

    MEMBER_DELETE_ERROR("商户成员删除失败");

    public final String name;

}
