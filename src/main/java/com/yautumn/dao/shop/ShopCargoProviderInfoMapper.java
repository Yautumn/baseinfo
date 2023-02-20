package com.yautumn.dao.shop;

import com.yautumn.common.entity.ShopCargoProviderInfo;

public interface ShopCargoProviderInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(ShopCargoProviderInfo record);

    int insertSelective(ShopCargoProviderInfo record);

    ShopCargoProviderInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ShopCargoProviderInfo record);

    int updateByPrimaryKey(ShopCargoProviderInfo record);
}