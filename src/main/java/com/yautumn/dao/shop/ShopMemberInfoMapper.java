package com.yautumn.dao.shop;

import com.yautumn.common.entity.shop.ShopMemberInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ShopMemberInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(ShopMemberInfo record);

    int insertSelective(ShopMemberInfo record);

    ShopMemberInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ShopMemberInfo record);

    int updateByPrimaryKey(ShopMemberInfo record);
}